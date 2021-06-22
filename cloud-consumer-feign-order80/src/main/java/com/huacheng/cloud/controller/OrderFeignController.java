package com.huacheng.cloud.controller;

import com.huacheng.cloud.entities.CommonResult;
import com.huacheng.cloud.entities.Payment;
import com.huacheng.cloud.service.PaymentFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: lwc
 * @time: 2021/3/4 19:01
 */
@RestController
@DefaultProperties(defaultFallback = "paymentInfo_Global_TimeOutHandler")
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get")
    public CommonResult<Payment> getPaymentById(Long id){
        return paymentFeignService.getPaymentById(id);
    }

//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1500")}
//    )
    @HystrixCommand
    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        return paymentFeignService.paymentFeignTimeout();
    }


    public String paymentInfo_TimeOutHandler(){
        return "线程名:" + Thread.currentThread().getName() + "客户端系统繁忙或运行错误,id" ;
    }

    // 下面是全局的FallBack方法
    public String paymentInfo_Global_TimeOutHandler(){
        return "Global异常处理信息,请稍后重试" ;
    }
}
