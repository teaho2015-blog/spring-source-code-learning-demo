package net.teaho.demo.spring.mvc.actuator.config;

import io.micrometer.core.instrument.MeterRegistry;
import net.teaho.demo.spring.mvc.actuator.health.SimpleEndpoint;
import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnEnabledEndpoint;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.actuate.beans.BeansEndpoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author teaho2015<at>gmail.com
 * @date 2020-08
 * @since 1.0.0
 */
@Configuration
public class BeanConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    @ConditionalOnEnabledEndpoint(endpoint = SimpleEndpoint.class)
    @ConditionalOnMissingBean
    public SimpleEndpoint simpleEndpoint() {
        return new SimpleEndpoint();
    }

    /**
     * 增加指标标签
     * @return
     */
    @Bean
    MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
        return registry -> registry.config().commonTags("region", "us-east-1");
    }

}
