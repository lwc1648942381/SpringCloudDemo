package com.huacheng.cloud.service;

import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: lwc
 * @time: 2021/3/16 0:04
 */
@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public String payment_ok(Integer id) {
        return "-----------PaymentFallbackService Fallback payment_ok";
    }

    @Override
    public String payment_timeout(Integer id) {
        return "-----------PaymentFallbackService Fallback payment_timeout";
    }
}
