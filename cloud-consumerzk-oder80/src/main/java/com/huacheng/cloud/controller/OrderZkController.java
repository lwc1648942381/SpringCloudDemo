package com.huacheng.cloud.controller;

import com.huacheng.cloud.entities.CommonResult;
import com.huacheng.cloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @description:
 * @author: lwc
 * @time: 2021/2/24 14:57
 */
@RestController
public class OrderZkController {

//    public static final String PAYMENT_URL="http://localhost:8001";
    public static final String PAYMENT_URL="http://cloud-provider-payment";
    @Resource
    private RestTemplate restTemplate;

    @PostMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"payment/create",payment,CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get")
    public CommonResult<Payment> getPayment(Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get?id="+id,CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/zk")
    public String getPayment(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/zk",String.class);
    }
}
