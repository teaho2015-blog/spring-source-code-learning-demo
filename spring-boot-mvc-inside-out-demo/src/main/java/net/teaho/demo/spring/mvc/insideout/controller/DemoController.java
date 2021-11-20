package net.teaho.demo.spring.mvc.insideout.controller;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
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

    @PostMapping("/demo2/time")
    public Map<String, String> demo2(@RequestParam String key) {
        return Collections.singletonMap("time", key + LocalDateTime.now());
    }

    @PostMapping("/demo3/time")
    public Map<String, String> demo3(@RequestParam String key) {
        throw new IllegalStateException("demo3 exception!!!");
    }

    @PostMapping("/api/body1")
    public Map<String, Object> body1(@RequestParam String id, Model model) {

        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("model", model);
        return map;
    }



}
