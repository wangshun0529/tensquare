package com.tensquare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * @description: ${description}
 * @Author wangshun
 * @create: 2019-11-22 23:46
 */
@SpringBootApplication
@EnableEurekaClient
public class BaseApplication{
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class,args);
        System.out.println("BaseApplication is running");
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }
}
