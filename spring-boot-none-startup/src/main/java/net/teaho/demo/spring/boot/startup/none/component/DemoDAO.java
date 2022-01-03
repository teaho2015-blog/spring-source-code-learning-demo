package net.teaho.demo.spring.boot.startup.none.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author teaho2015<at>gmail<dot>com
 * @date 2020-06
 * @since 1.0.0
 */
@Slf4j
@Component
public class DemoDAO {


    public DemoBean getDemo() {
        return DemoBean.builder()
            .name("demoBean")
            .build();
    }
}
