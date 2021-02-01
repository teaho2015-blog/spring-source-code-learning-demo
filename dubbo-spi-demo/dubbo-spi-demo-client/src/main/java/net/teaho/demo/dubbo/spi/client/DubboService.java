package net.teaho.demo.dubbo.spi.client;

import lombok.extern.slf4j.Slf4j;
import net.teaho.demo.dubbo.spi.api.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

/**
 * @author hetl@akulaku.com
 * @date 2021-01
 * @since 1.0.0
 */
@Component
@Slf4j
public class DubboService {

    @Reference(url = "dubbo://localhost:22301", group = "dev")
    private UserService userService;

    public void printUser() {
        log.info(userService.getUser(1).toString());
    }
}
