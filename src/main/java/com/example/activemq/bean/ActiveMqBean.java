package com.example.activemq.bean;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * Description:
 *
 * @author shichengyao
 * @Date 2017/12/8
 */
@Configuration
public class ActiveMqBean {
    @Bean
    public Queue queueSimple() {
        return new ActiveMQQueue("sample.queue");
    }

    @Bean(name = "virtualColor")
    public Topic topicVirtualColor() {
        return new ActiveMQTopic("VirtualTopic.color");
    }
}
