package net.teaho.demo.spring.cloud.context.named;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.named.NamedContextFactory;

/**
 * @author teaho2015@gmail.com
 * @date 2020-06
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
public class SimpleNamedSpecification implements NamedContextFactory.Specification {

    private String name;

    private Class<?>[] configuration;

    public SimpleNamedSpecification(String s, Class<?>[] classes) {
        name = s;
        configuration = classes;
    }
}
