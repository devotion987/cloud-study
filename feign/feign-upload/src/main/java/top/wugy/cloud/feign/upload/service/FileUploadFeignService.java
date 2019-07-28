package top.wugy.cloud.feign.upload.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import top.wugy.cloud.feign.upload.config.FeignMultipartSupportConfig;

/**
 * guangyao.wu 2019/7/28 16:21
 */
@FeignClient(value = "feign-provider", configuration = FeignMultipartSupportConfig.class)
public interface FileUploadFeignService {

    /***
     * 1.produces,consumes必填
     * 2.注意区分@RequestPart和RequestParam，不要将
     * @RequestPart(value = "file") 写成@RequestParam(value = "file")
     */
    @RequestMapping(method = RequestMethod.POST, value = "/uploadFile/server",
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String fileUpload(MultipartFile file);
}
