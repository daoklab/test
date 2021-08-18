package com.daoklab.test.rocketmq.consumer;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "Topic", consumerGroup = "test-group",
        selectorType = SelectorType.TAG, selectorExpression = "Tag",
        messageModel = MessageModel.CLUSTERING)
public class TestConsumer implements RocketMQListener<MessageExt> {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Override
    public void onMessage(MessageExt messageExt) {
        LOGGER.info("接收到消息内容》》{}", new String(messageExt.getBody()));
    }

}
