package com.daoklab.springevent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Project: test
 * @Pacakge: com.daoklab.springevent
 * @Author: liuxianglin
 * @Description: TODO
 * @Date: Created in 12:53 2021/7/24
 */
@EnableAsync
@SpringBootApplication
public class SpringEventApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringEventApplication.class, args);
    }
}
