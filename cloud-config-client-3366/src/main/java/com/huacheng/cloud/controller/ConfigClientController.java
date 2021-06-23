package com.huacheng.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <功能描述>
 *
 * @author luo
 * @date: 2021/06/23 17:10
 * @version: 1.0.0
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${mybatis.mapper-locations}")
    private String locations;

    @GetMapping("configinfo")
    public String getConfig(){
        return locations;
    }
}