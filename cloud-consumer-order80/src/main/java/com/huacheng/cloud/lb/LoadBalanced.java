package com.huacheng.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 
 * @author: lwc
 * @date: 2021/3/4 17:50
 * 
 **/
public interface LoadBalanced {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
