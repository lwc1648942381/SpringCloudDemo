package com.huacheng.cloud.dao;

import com.huacheng.cloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author: luowc
 * @date: 2021/2/23 22:46
 * 
 **/
@Mapper
public interface PaymentDao {
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
    Payment getPaymentById(@Param("id") Long id);
}
