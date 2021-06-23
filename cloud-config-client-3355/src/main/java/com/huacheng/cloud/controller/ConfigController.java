package com.huacheng.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: lwc
 * @time: 2021/6/23 0:38
 */
@RestController
@RefreshScope
public class ConfigController {

    @Value("${mybatis.mapper-locations}")
    private String locations;

    @GetMapping("configinfo")
    public String getConfig(){
        return locations;
    }
}
