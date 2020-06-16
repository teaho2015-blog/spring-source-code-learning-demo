/**
 * @author teaho2015<at>gmail<dot>com
 * since 2020
 */
package net.teaho.demo.spring.boot.startup.none.spring.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class EchoApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("EchoApplicationRunner running, args:{}", args);
    }
}
