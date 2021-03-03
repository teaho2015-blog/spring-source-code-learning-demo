package net.teaho.demo.spring.mvc.actuator.health;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hetl@akulaku.com
 * @date 2020-08
 * @since 1.0.0
 */
@Endpoint(id = "simple")
public class SimpleEndpoint {


    @ReadOperation
    public SimpleResult simple() {
        Map<String, String> result = new HashMap<>(1<<2);
        result.put("msg", "none");
        result.put("status", "unknown");
        return new SimpleResult(result);
    }



    public static final class SimpleResult {

        private final Map<String, String> result;

        private SimpleResult(Map<String, String> result) {
            this.result = result;
        }

        public Map<String, String> getResult() {
            return this.result;
        }
    }
}
