package com.huacheng.cloud.controller;

import com.huacheng.cloud.service.IMessageProvider;
import com.huacheng.cloud.service.impl.MessageProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <功能描述>
 *
 * @author luo
 * @date: 2021/06/24 17:10
 * @version: 1.0.0
 */
@RestController
public class SendMessageController {

    @Resource
    private MessageProviderImpl messageProvider;

    @GetMapping(value = "/sendMessage")
    public String sendMessage()
    {
        return messageProvider.send();
    }

}
