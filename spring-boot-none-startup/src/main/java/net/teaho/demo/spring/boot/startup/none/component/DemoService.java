package net.teaho.demo.spring.boot.startup.none.component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Optional;

/**
 * @author teaho2015<at>gmail.com
 * @date 2020-06
 * @since 1.0.0
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class DemoService {

    private final Map<String, String> map1;
    private final Optional<Map<String, String>> map3;
    private final Optional<Map<String, String>> map4;
    @Autowired
    private DemoBean demoBean;

    @PostConstruct
    public void printMap() {
        log.info("map is:{}", map1);
        log.info("demoBean is:{}", demoBean);
        log.info("map3 is:{}", map3);
        log.info("map4 is:{}", map4);
    }


}
