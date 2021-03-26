package net.teaho.demo.spring.cloud.web.client.ribbon;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;

/**
 * @author teaho2015@gmail.com
 * @date 2020-07
 * @since 1.0.0
 */
@Slf4j
public class SimpleRule extends RandomRule {
    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        log.info("clientConfig: {}", clientConfig);
        super.initWithNiwsConfig(clientConfig);
    }

    @Override
    public Server choose(Object key) {
        log.info("key: {}", key);
        return super.choose(key);
    }
}
