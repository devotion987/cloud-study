package top.wugy.cloud.feign.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * guangyao.wu 2019/7/28 14:20
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ProviderApp {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApp.class);
    }

}
