package net.teaho.demo.spring.web.api.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("net.teaho.demo.spring.web.api")
public class ClientAutoConfiguration {
}
