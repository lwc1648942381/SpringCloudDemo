package com.huacheng.cloud.controller;

import com.huacheng.cloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: lwc
 * @time: 2021/3/9 17:05
 */
@RestController
public class OrderHystrixController {
    @Resource
    PaymentService paymentService;

    @GetMapping(value = "/consumer/payment/ok")
    public String payment_ok(Integer id) {
        return paymentService.payment_ok(id);
    }

    @GetMapping(value = "/consumer/payment/timeout")
    public String payment_timeout(Integer id) {
        return paymentService.payment_timeout(id);
    }
}
