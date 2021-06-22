package com.huacheng.cloud.controller;

import cn.hutool.core.util.IdUtil;
import com.huacheng.cloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: lwc
 * @time: 2021/3/9 16:20
 */
@RestController
public class PaymentHystrixController {

    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/payment/ok")
    public String payment_ok(Integer id) {
        return "线程名:" + Thread.currentThread().getName() + "payment_ok,id:" + id;
    }

    @GetMapping(value = "/payment/timeout")
    public String payment_timeout(Integer id) {
        return paymentService.payment_timeout(id);
    }

    // 服务熔断
    @GetMapping(value = "/payment/paymentCircuitBreaker")
    public String paymentCircuitBreaker(Integer id){
        return paymentService.paymentCircuitBreaker(id);
    }
}
