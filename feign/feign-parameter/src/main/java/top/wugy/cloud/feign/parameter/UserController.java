package top.wugy.cloud.feign.parameter;

import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * guangyao.wu 2019/7/28 10:48
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserFeignService userFeignService;

    /**
     * 用于演示Feign的Get请求多参数传递
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@RequestBody @ApiParam(name = "用户", value = "传入json格式", required = true) User user) {
        return userFeignService.addUser(user);
    }

    /**
     * 用于演示Feign的Post请求多参数传递
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUser(@RequestBody @ApiParam(name = "用户", value = "传入json格式", required = true) User user) {
        return userFeignService.updateUser(user);
    }

}