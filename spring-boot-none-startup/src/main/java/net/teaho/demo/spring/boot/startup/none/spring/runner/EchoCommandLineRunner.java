/**
 * @author teaho2015<at>gmail<dot>com
 * since 2020
 */
package net.teaho.demo.spring.boot.startup.none.spring.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class EchoCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("EchoCommandLineRunner running");
        for (String s : args) {
            log.info(s);
        }
    }
}
