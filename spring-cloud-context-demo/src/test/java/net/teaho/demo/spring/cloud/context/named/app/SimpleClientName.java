package net.teaho.demo.spring.cloud.context.named.app;

import org.springframework.beans.factory.annotation.Value;

import java.lang.annotation.*;

/**
 * @author teaho2015@gmail.com
 * @date 2020-06
 * @since 1.0.0
 */
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,
    ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Value("${simple.client.name}")
public @interface SimpleClientName {

}
