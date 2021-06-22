package com.huacheng.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description:
 * @author: lwc
 * @time: 2021/2/27 0:53
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PayMentMain8006 {

    public static void main(String[] args) {
        SpringApplication.run(PayMentMain8006.class,args);
    }
}
