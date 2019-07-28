package top.wugy.cloud.feign.interceptor;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.*;

/**
 * guangyao.wu 2019/7/28 10:28
 */
@Component
public class FeignRequestInterceptor implements RequestInterceptor {

    @Resource
    private ObjectMapper objectMapper;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        // feign 不支持 GET 方法传 POJO, json body转query
        if (RequestMethod.GET.name().equals(requestTemplate.method()) && null != requestTemplate.requestBody()) {
            try {
                JsonNode jsonNode = objectMapper.readTree(requestTemplate.requestBody().asBytes());

                Map<String, Collection<String>> queries = new HashMap<>();
                buildQuery(jsonNode, "", queries);
                requestTemplate.queries(queries);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    private void buildQuery(JsonNode jsonNode, String path, Map<String, Collection<String>> queries) {
        if (!jsonNode.isContainerNode()) { // 叶子节点
            if (jsonNode.isNull()) {
                return;
            }
            Collection<String> values = queries.computeIfAbsent(path, (list) -> new ArrayList<>());
            values.add(jsonNode.asText());
            return;
        }
        if (jsonNode.isArray()) { // 数组节点
            Iterator<JsonNode> it = jsonNode.elements();
            while (it.hasNext()) {
                buildQuery(it.next(), path, queries);
            }
        } else {
            Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
            while (it.hasNext()) {
                Map.Entry<String, JsonNode> entry = it.next();
                if (StringUtils.hasText(path)) {
                    buildQuery(entry.getValue(), path + "." + entry.getKey(), queries);
                } else {  // 根节点
                    buildQuery(entry.getValue(), entry.getKey(), queries);
                }
            }
        }
    }
}
