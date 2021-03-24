package net.teaho.demo.spring.cloud.context.named.app;

import net.teaho.demo.spring.cloud.context.named.SimpleNamedContextFactory;
import net.teaho.demo.spring.cloud.context.named.SimpleNamedSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author teaho2015@gmail.com
 * @date 2021-03
 * @since 1.0.0
 */
@Configuration
public class NamedConfiguration {

    @Autowired(required = false)
    private List<SimpleNamedSpecification> specs = new ArrayList<>();


    @Bean
    public SimpleNamedContextFactory simpleNamedContextFactory() {
        SimpleNamedContextFactory simpleNamedContextFactory = new SimpleNamedContextFactory();
        simpleNamedContextFactory.setConfigurations(specs);
        return simpleNamedContextFactory;
    }

    @Bean
    public SimplePropertiesFactory simplePropertiesFactory() {
        return new SimplePropertiesFactory();
    }

//    @Bean
//    @ConditionalOnMissingBean
//    public Rule rule() {
//        return new Rule.Default();
//    }

}
