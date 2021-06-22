package com.huacheng.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description:
 * @author: lwc
 * @time: 2021/2/23 22:41
 */
@Data
// 全参构造器
@AllArgsConstructor
// 无参构造器
@NoArgsConstructor
public class Payment implements Serializable {

    private Long id;

    private String serial;
}
