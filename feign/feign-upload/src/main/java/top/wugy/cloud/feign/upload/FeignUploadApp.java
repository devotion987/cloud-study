package top.wugy.cloud.feign.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * guangyao.wu 2019/7/28 16:26
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class FeignUploadApp {

    public static void main(String[] args) {
        SpringApplication.run(FeignUploadApp.class, args);
    }
}
