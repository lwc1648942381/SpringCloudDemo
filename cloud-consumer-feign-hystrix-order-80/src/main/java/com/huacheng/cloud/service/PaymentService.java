package com.huacheng.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * @author: lwc
 * @date: 2021/3/9 17:03
 * 
 **/
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping(value = "/payment/ok")
    public String payment_ok(@RequestParam("id") Integer id);

    @GetMapping(value = "/payment/timeout")
    public String payment_timeout(@RequestParam("id") Integer id) ;
}
