package top.wugy.cloud.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * guangyao.wu 2019/7/28 8:30
 */
@EnableFeignClients
@SpringBootApplication
public class FeignParameterApp {

    public static void main(String[] args) {
        SpringApplication.run(FeignParameterApp.class, args);
    }
}
