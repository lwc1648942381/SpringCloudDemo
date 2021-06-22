package com.huacheng.cloud.service;

import com.huacheng.cloud.entities.Payment;

/**
 * 
 * @author: luowc
 * @date: 2021/2/23 22:58
 * 
 **/
public interface PaymentService {
    /**
     * 创建
     * @param payment
     * @return
     */
    int create(Payment payment);

    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    Payment getPaymentById(Long id);
}
