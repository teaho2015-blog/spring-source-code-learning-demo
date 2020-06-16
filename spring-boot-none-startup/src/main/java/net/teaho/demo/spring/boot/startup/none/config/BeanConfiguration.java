package net.teaho.demo.spring.boot.startup.none.config;

import net.teaho.demo.spring.boot.startup.none.spring.spi.DemoSpringLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author teaho2015
 * @date 2020-05
 * @since 1.0.0
 */
@Configuration
public class BeanConfiguration {

    @Bean
    public Map<String, String> map() {
        return new HashMap<>(1 << 4);
    }


    /**
     * 加载自定义Spring SPI
     * @return
     */
    @Bean
    public Object testSpringSPI() {


        Set<String> names = new LinkedHashSet<>(
                SpringFactoriesLoader.loadFactoryNames(DemoSpringLoader.class, this.getClass().getClassLoader()));


        System.out.println(names);
        return new Object();
    }
}
