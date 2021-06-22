package com.huacheng.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 规则类  避免与@ComponentScan 同包以及子包
 * @author: lwc
 * @time: 2021/2/27 16:23
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        return new RandomRule(); // 定义为随机
    }
}
