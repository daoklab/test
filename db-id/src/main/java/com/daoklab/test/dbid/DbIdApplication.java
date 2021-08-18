package com.daoklab.test.dbid;

import com.daoklab.test.dbid.commons.utils.SnowflakeIdWorker;
import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName DbIdApplication
 * @Description TODO
 * @Author xianglin
 * @Date 2021/8/17 18:15
 * @Version V1.0
 */
@SpringBootApplication
@ServletComponentScan
@MapperScan(basePackages = "com.daoklab.test.dbid.dao")
public class DbIdApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbIdApplication.class, args);
    }

    @Bean
    public SnowflakeIdWorker snowflakeIdWorker(){

        String workerId = System.getProperty("snowflake.defalut.workerId");
        String datacenterId = System.getProperty("snowflake.defalut.datacenterId");

        SnowflakeIdWorker sf = new SnowflakeIdWorker(
                StringUtils.isBlank(workerId) ? 10L : Long.valueOf(workerId),
                StringUtils.isBlank(datacenterId) ? 10L : Long.valueOf(datacenterId));
        return sf;
    }

}
