package com.tensquare.sms.linstener;

import com.aliyuncs.exceptions.ClientException;
import com.tensquare.sms.utils.SmsUtil;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "sms")
public class SmsLinstener {

    @Autowired
    private SmsUtil smsUtil;

    @Value("${aliyun.sms.template_code}")
    private String template_code;

    @Value("${aliyun.sms.sign_name}")
    private String sign_name;
    /**
     *  发送短信
     * @param message
     */
    @RabbitHandler
    public void sendSms(Map<String,String> message) throws ClientException {
        String mobile = message.get("mobile");
        String code = message.get("code");
        System.out.println("手机号："+message.get("mobile"));
        System.out.println("验证码："+message.get("code"));
        smsUtil.sendSms(mobile,template_code,sign_name,"{\"code\":\""+code+"\"}");
    }



}
