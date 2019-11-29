package com.tensquare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @description:
 * @Author wangshun
 * @create: 2019-11-29 10:06
 */
@EnableConfigServer //开启配置服务
@SpringBootApplication
public class ConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class , args);
        System.out.println("ConfigApplication is running");
    }
}
