package com.huacheng.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: lwc
 * @time: 2021/6/21 0:26
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator baiduRouteLocator(RouteLocatorBuilder builder){
      return   builder.routes().route("path_huacheng_baidu",r->r.path("/guonei").uri("http://news.baidu.com/gounei")).build();
    }
}
