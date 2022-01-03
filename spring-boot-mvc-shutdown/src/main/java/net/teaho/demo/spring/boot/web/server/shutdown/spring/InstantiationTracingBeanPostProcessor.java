package net.teaho.demo.spring.boot.web.server.shutdown.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author teaho2015
 * @date 2020-05
 * @since 1.0.0
 */
@Component
@Slf4j
public class InstantiationTracingBeanPostProcessor implements BeanPostProcessor {

    // simply return the instantiated bean as-is
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        return bean; // we could potentially return any object reference here...
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        log.info("Bean '" + beanName + "' created : " + bean.toString());
        return bean;
    }
}
