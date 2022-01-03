package net.teaho.demo.spring.cloud.discovery.api.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("net.teaho.demo.spring.cloud.discovery.api")
public class ClientAutoConfiguration {
    @Bean
    public UserFeignFallback userFeignFallback() {
        return new UserFeignFallback();
    }
}
