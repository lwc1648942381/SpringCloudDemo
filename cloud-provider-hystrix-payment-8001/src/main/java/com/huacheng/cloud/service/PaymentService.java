package com.huacheng.cloud.service;


public interface PaymentService {
    String payment_ok(Integer id);

    String payment_timeout(Integer id);

     String paymentCircuitBreaker(Integer id);
}
