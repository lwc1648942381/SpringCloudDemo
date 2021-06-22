package com.huacheng.cloud.controller;

import com.huacheng.cloud.entities.CommonResult;
import com.huacheng.cloud.entities.Payment;
import com.huacheng.cloud.lb.LoadBalanced;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @description:
 * @author: lwc
 * @time: 2021/2/24 14:57
 */
@RestController
public class OrderController {

//    public static final String PAYMENT_URL="http://localhost:8001";
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private LoadBalanced loadBalanced;
    @Resource
    private RestTemplate restTemplate;
    @Resource
    DiscoveryClient discoveryClient;

    @PostMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"payment/create",payment,CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get")
    public CommonResult<Payment> getPayment(Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get?id="+id,CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/lb")
    public String getLb(Long id){
        List<ServiceInstance> serviceInstance=discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance instances = loadBalanced.instances(serviceInstance);
        URI uri = instances.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }
}
