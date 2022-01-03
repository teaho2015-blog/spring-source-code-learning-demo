package net.teaho.demo.springcloud.zookeeper;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@RefreshScope
@Configuration
@ConfigurationProperties("global.sample")
public class Example {
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
}