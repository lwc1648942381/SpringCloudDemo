package com.huacheng.cloud.service.impl;

import com.huacheng.cloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.transform.Source;
import java.util.UUID;

/**
 * <功能描述>
 *
 * @author luo
 * @date: 2021/06/24 17:08
 * @version: 1.0.0
 */
@EnableBinding(Source.class) //定义消息的推送管道
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output; // 消息发送管道


    @Override
    public String send() {
//        String serial = UUID.randomUUID().toString();
//        output.send(MessageBuilder.withPayload(serial).build());
//        System.out.println("*****serial: "+serial);
       return null;
    }
}
