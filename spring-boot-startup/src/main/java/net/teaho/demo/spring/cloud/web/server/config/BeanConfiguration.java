package net.teaho.demo.spring.cloud.web.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author teaho2015
 * @date 2020-05
 * @since 1.0.0
 */
@Configuration
public class BeanConfiguration {

    @Bean
    public Map<String, String> map() {
        return new HashMap<>(1 << 4);
    }
}
