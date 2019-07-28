package top.wugy.cloud.feign.client;

import feign.Feign;
import okhttp3.ConnectionPool;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * guangyao.wu 2019/7/28 9:15
 */
@Configuration
@ConditionalOnClass(Feign.class)
@AutoConfigureBefore(FeignAutoConfiguration.class)
public class FeignOkHttpConfig {

    @Bean
    public okhttp3.OkHttpClient okHttpClient() {
        return new okhttp3.OkHttpClient().newBuilder().connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS).writeTimeout(60, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true).connectionPool(new ConnectionPool())
                .build();
    }
}
