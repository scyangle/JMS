package com.example.activemq.bean;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

/**
 * Description:
 *
 * @author shichengyao
 * @Date 2017/12/8
 */
@Configuration
public class ActiveMqBean {
    @Bean
    public Queue queue() {
        return new ActiveMQQueue("sample.queue");
    }
}
