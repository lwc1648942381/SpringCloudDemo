package com.huacheng.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @description:
 * @author: lwc
 * @time: 2021/3/9 16:12
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class PayMentHystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PayMentHystrixMain8001.class,args);
    }
}
