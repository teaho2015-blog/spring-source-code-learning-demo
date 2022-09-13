package net.teaho.demo.springcloud.zookeeper;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;

@RefreshScope
@Configuration
@ConfigurationProperties("global.sample")
public class Example implements InitializingBean {

    public Example() {
        System.out.println("Example construct.");
    }

    /**
     * /config/global/spring-cloud-zk-config-demo,dev/global.sample.serverEnabled
     */
    private String serverEnabled;
 
    private String featureLogEnabled;

    public String getServerEnabled() {
        return serverEnabled;
    }

    public void setServerEnabled(String serverEnabled) {
        this.serverEnabled = serverEnabled;
    }

    public String getFeatureLogEnabled() {
        return featureLogEnabled;
    }

    public void setFeatureLogEnabled(String featureLogEnabled) {
        this.featureLogEnabled = featureLogEnabled;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Example afterPropertiesSet");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Example destroy!");
    }
}