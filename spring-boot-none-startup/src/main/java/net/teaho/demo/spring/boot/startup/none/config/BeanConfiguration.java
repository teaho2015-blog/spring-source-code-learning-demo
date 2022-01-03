package net.teaho.demo.spring.boot.startup.none.config;

import lombok.extern.slf4j.Slf4j;
import net.teaho.demo.spring.boot.startup.none.spring.spi.DemoSpringLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.*;

/**
 * @author teaho2015
 * @date 2020-05
 * @since 1.0.0
 */
@Configuration
@Slf4j
public class BeanConfiguration {

    @Bean
    public Map<String, String> map1() {
        return new HashMap<>(1 << 4);
    }

    @Bean
    public Map<String, String> map2() {
        return new HashMap<>(1 << 4);
    }


    /**
     * 加载自定义Spring SPI, 若想在创建对象时加构造参数，参考SpringApplication的几个getSpringFactoriesInstances private方法
     * @return
     */
    @Bean
    public Object testSpringSPI() {
        List<DemoSpringLoader> inst = new ArrayList<>(
                SpringFactoriesLoader.loadFactories(DemoSpringLoader.class, this.getClass().getClassLoader()));

        log.info(inst.toString());
        return new Object();
    }

}
