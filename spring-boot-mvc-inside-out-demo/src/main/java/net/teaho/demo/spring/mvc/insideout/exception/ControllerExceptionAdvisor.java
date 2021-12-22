package net.teaho.demo.spring.mvc.insideout.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hetingleong@xiaomi.com
 * @date 2021-11
 */
@RestControllerAdvice
public class ControllerExceptionAdvisor {


    @ExceptionHandler(Exception.class)
    public Map exception(Exception e) {
        Map<String, String> map = new HashMap<>();
        map.put("key", "key123");
        return map;
    }


}
