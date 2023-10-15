package com.jydev.eurekaserver.config;

import com.netflix.appinfo.AmazonInfo;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AwsEurekaConfig {
    @Bean
    @Profile({"!local", "!default"})
    public EurekaInstanceConfigBean eurekaInstanceConfig(InetUtils inetUtils) {
        EurekaInstanceConfigBean bean = new EurekaInstanceConfigBean(inetUtils);
        AmazonInfo info = AmazonInfo.Builder.newBuilder()
                .autoBuild("eureka");
        bean.setDataCenterInfo(info);
        return bean;
    }
}
