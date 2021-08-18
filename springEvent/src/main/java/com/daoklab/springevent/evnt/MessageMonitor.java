package com.daoklab.springevent.evnt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Project: test
 * @Pacakge: com.daoklab.springevent
 * @Author: liuxianglin
 * @Description: TODO
 * @Date: Created in 13:14 2021/7/24
 */
@Component
public class MessageMonitor {

    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Async("lazyTraceExecutor")
    @EventListener(value = MessageActionEvent.class)
    public MessageActionEvent listenMessageEvent(MessageActionEvent messageActionEvent) {
        MessageBody messageBody = messageActionEvent.getMessageBody();
        LOGGER.info("======================================================");
        LOGGER.info("事件类型 => " + messageActionEvent.getOperate().getDesc());
        LOGGER.info("消息标题 => " + messageBody.getTitle());
        LOGGER.info("消息内容 => " + messageBody.getContent());
        return messageActionEvent;
    }

}
