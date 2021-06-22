package com.huacheng.cloud.service.impl;

import com.huacheng.cloud.dao.PaymentDao;
import com.huacheng.cloud.entities.Payment;
import com.huacheng.cloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: lwc
 * @time: 2021/2/23 22:59
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
