package net.teaho.demo.spring.cloud.web.client.ribbon;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.DummyPing;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;

/**
 * @author teaho2015@gmail.com
 * @date 2020-07
 * @since 1.0.0
 */
@Slf4j
public class SimplePing extends DummyPing {

    public SimplePing() {
        super();
    }

    @Override
    public boolean isAlive(Server server) {
        log.info("server: {}", server);
        return super.isAlive(server);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        log.info("clientConfig: {}", clientConfig);
        super.initWithNiwsConfig(clientConfig);
    }
}
