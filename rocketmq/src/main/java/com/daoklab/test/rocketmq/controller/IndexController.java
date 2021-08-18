package com.daoklab.test.rocketmq.controller;

import com.alibaba.fastjson.JSONObject;
import com.daoklab.test.rocketmq.provider.TestProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class IndexController {

    @Autowired
    private TestProvider testProvider;

    @GetMapping
    public String index() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("a","bbbbb");
        testProvider.convertAndSend(jsonObject);
        return "index";
    }

}
