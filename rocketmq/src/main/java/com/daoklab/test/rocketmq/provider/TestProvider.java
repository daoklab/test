package com.daoklab.test.rocketmq.provider;

import com.alibaba.fastjson.JSONObject;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestProvider {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public void convertAndSend(JSONObject jsonObject) {
        LOGGER.info("发送消息开始》》》消息体：{}", jsonObject.toJSONString());
        rocketMQTemplate.convertAndSend("Topic" + ":" + "Tag", jsonObject.toJSONString());
        LOGGER.info("发送消息完成》》》", jsonObject.toJSONString());
    }

}
