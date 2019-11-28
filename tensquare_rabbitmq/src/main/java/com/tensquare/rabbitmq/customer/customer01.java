package com.tensquare.rabbitmq.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @Author wangshun
 * @create: 2019-11-27 10:44
 */
@Component
@RabbitListener(queues = "ddtpopularize.email")
public class customer01 {

    @RabbitHandler
    public void showMessage(String msg){
        System.out.println("发送邮件业务："+ msg);
    }

}
