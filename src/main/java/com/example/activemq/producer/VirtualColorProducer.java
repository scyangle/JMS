package com.example.activemq.producer;

import org.apache.activemq.command.ActiveMQMapMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Topic;

/**
 * Description:
 *
 * @author shichengyao
 * @Date 2017/12/19
 */
@Component
public class VirtualColorProducer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Resource
    private Topic virtualColor;

    public void sendTopicColorMessage(String id) throws JMSException {
        MapMessage mapMessage = new ActiveMQMapMessage();
        mapMessage.setString("id",id);
        mapMessage.setString("typeName", "topic");
        mapMessage.setString("color","yellow");
        jmsMessagingTemplate.convertAndSend(virtualColor, mapMessage);
    }
}
