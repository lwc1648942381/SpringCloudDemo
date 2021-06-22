package com.huacheng.cloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.huacheng.cloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: lwc
 * @time: 2021/3/9 16:16
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String payment_ok(Integer id) {
        return "线程名:" + Thread.currentThread().getName() + "payment_ok,id:" + id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")}
    )
    @Override
    public String payment_timeout(Integer id) {
//        int time=5;
//        try {
//            TimeUnit.SECONDS.sleep(time);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        int a=10/0;
        return "线程名:" + Thread.currentThread().getName() + "payment_timeout,id" + id;
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程名:" + Thread.currentThread().getName() + "系统繁忙或运行错误,id" + id;
    }


    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"), // 是否开启短路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"), // 请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60") // 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id){
        if(id<0){
            throw new RuntimeException("*****id不能为负数");
        }
        String uuid= IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功,流水号:"+uuid;
    }

    public String paymentCircuitBreaker_fallback(Integer id){
        return "id不能为负数";
    }
}
