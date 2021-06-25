package com.huacheng.cloud.controller;


import com.huacheng.cloud.entities.CommonResult;
import com.huacheng.cloud.entities.Payment;
import com.huacheng.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * @description:
 * @author: lwc
 * @time: 2021/2/23 23:01
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result=paymentService.create(payment);
        log.info("***********插入结果:"+result);
        if(result>0){
            return new CommonResult(200,"插入数据库成功,serverport:"+serverPort,result);
        }else{
            return new CommonResult(444,"插入数据库失败");
        }
    }

    @GetMapping(value = "/payment/get")
    public CommonResult<Payment> getPaymentById(Long id){
        Payment paymentById = paymentService.getPaymentById(id);
        if(paymentById!=null){
            return new CommonResult(200,"查询成功,serverport:"+serverPort,paymentById);
        }else{
            return new CommonResult(444,"查询失败,没有对应的记录");
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for(String item:services){
            log.info("*****element:"+item);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance item:instances){
            log.info(item.getServiceId()+"\t"+item.getHost()+"\t"+item.getPort()+"\t"+item.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value="/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin(){
        return "Hi,i'am paymentZipkin server fall back";
    }
}
