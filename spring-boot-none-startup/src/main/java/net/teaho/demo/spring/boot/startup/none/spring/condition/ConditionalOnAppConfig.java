package net.teaho.demo.spring.boot.startup.none.spring.condition;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Conditional;

/**
 * @author teaho2015@gmail.com
 * @date 2023-10
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
@Documented
@Conditional(OnAppConfigCondition.class)
public @interface ConditionalOnAppConfig {

	String value() default "";

}
