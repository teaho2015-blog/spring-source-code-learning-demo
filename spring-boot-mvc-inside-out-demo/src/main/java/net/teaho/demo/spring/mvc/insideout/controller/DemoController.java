package net.teaho.demo.spring.mvc.insideout.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;

/**
 * @author hetingleong@xiaomi.com
 * @date 2021-10
 */
@RestController
public class DemoController {

    @PostMapping("/demo/time")
    public Map<String, String> demo() {
        return Collections.singletonMap("time", LocalDateTime.now().toString());
    }



}
