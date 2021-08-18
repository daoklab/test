package com.daoklab.springevent.controller;

import com.daoklab.springevent.evnt.EnumMessageType;
import com.daoklab.springevent.evnt.MessageActionEvent;
import com.daoklab.springevent.evnt.MessageBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.time.LocalDateTime;

/**
 * @Project: test
 * @Pacakge: com.daoklab.springevent
 * @Author: liuxianglin
 * @Description: TODO
 * @Date: Created in 13:00 2021/7/24
 */
@Service
@RestController
public class TestController {

    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping
    public String publish() {
        MessageBody messageBody = new MessageBody();
        messageBody.setTitle("消息标题 - " + LocalDateTime.now());
        messageBody.setContent("现在时间是：" + LocalDateTime.now());
        MessageActionEvent messageActionEvent = new MessageActionEvent(this);
        messageActionEvent.setOperate(EnumMessageType.NORMAL);
        messageActionEvent.setMessageBody(messageBody);
        applicationContext.publishEvent(messageActionEvent);
        LOGGER.info(MessageFormat.format("发布消息事件 => {0}", messageActionEvent.getMessageBody().getContent()));
        return "Publish Success";
    }

}
