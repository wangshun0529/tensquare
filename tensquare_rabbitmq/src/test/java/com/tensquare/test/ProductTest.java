package com.tensquare.test;

import com.tensquare.rabbitmq.RabbitmqApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description:
 * @Author wangshun
 * @create: 2019-11-27 10:24
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitmqApplication.class)
public class ProductTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void product1(){
        rabbitTemplate.convertAndSend("first","第一条测试--直接模式");
    }

    @Test
    public void product2(){
        rabbitTemplate.convertAndSend("test.fanout","","--分裂模式");
    }
    @Test
    public void product3(){
        rabbitTemplate.convertAndSend("topic.ddtpopularize","email.sms","--主题模式");
    }
}
