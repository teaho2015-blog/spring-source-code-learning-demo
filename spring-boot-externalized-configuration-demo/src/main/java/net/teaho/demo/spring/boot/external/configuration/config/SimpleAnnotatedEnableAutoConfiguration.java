package net.teaho.demo.spring.boot.external.configuration.config;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

/**
 * @author teaho2015@gmail.com
 * @date 2020-07
 * @since 1.0.0
 */
@Configuration
@ConditionalOnProperty(name = "simple.config.annotated.enabled", havingValue = "true")
@EnableConfigurationProperties(SimpleAnnotatedEnableConfigProperties.class)
@AutoConfigureOrder(Ordered.LOWEST_PRECEDENCE - 10000)
public class SimpleAnnotatedEnableAutoConfiguration {


}
