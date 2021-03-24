package net.teaho.demo.spring.cloud.context.named;

import org.springframework.cloud.context.named.NamedContextFactory;

/**
 * @author teaho2015@gmail.com
 * @date 2020-06
 * @since 1.0.0
 */
public class SimpleNamedContextFactory extends NamedContextFactory<SimpleNamedSpecification> {

    public static final String NAMESPACE = "simple";

    public SimpleNamedContextFactory() {
        super(SimpleNamedSpecification.class, NAMESPACE, NAMESPACE + ".client.name");

    }
}
