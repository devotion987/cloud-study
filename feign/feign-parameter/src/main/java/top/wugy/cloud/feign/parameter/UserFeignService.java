package top.wugy.cloud.feign.parameter;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * guangyao.wu 2019/7/28 10:53
 */
@FeignClient(name = "user-provider")
public interface UserFeignService {

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    String addUser(@RequestBody User user);

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    String updateUser(@RequestBody User user);
}
