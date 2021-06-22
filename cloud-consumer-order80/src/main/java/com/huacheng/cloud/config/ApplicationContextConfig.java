package com.huacheng.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: lwc
 * @time: 2021/2/24 15:00
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced // 开启restTemplate的负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
