package com.huacheng.cloud.service;

import com.huacheng.cloud.entities.CommonResult;
import com.huacheng.cloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * @author: lwc
 * @date: 2021/3/4 18:58
 * 
 **/
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get")
    public CommonResult<Payment> getPaymentById(@RequestParam("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}
