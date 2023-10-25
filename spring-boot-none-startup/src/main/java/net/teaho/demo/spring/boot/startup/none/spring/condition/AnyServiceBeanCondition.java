package net.teaho.demo.spring.boot.startup.none.spring.condition;

import net.teaho.demo.spring.boot.startup.none.component.DemoService;
import net.teaho.demo.spring.boot.startup.none.component.DemoService2;
import org.springframework.boot.autoconfigure.condition.AnyNestedCondition;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

/**
 * @author teaho2015@gmail.com
 * @date 2023-10
 */
public class AnyServiceBeanCondition extends AnyNestedCondition {

    AnyServiceBeanCondition() {
        super(ConfigurationPhase.REGISTER_BEAN);
    }

    @ConditionalOnBean(DemoService2.class)
    static class DemoService2Available {

    }

    @ConditionalOnBean(DemoService.class)
    static class DemoServiceAvailable {

    }

}