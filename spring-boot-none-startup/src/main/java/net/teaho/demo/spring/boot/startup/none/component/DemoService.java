package net.teaho.demo.spring.boot.startup.none.component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author hetl@akulaku.com
 * @date 2020-06
 * @since 1.0.0
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class DemoService {

    private final Map<String, String> map;

    public void printMap() {
        log.info("map is:{}", map);
    }
}
