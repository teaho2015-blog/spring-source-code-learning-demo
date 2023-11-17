package net.teaho.demo.spring.aop.insideout.config;

import net.teaho.demo.spring.aop.insideout.support.LogAspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author teaho2015@gmail.com
 * @date 2023-11
 */
@Configuration
public class AppConfig {

    @Bean
    @ConditionalOnProperty(havingValue = "true", name = "abc")
    public LogAspect logAspect() {
        return new LogAspect();
    }
}
