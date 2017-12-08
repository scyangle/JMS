package com.example.activemq.producer;

import org.apache.activemq.command.ActiveMQMapMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Queue;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author shichengyao
 * @Date 2017/11/30
 */
@Component
public class ActiveMqProducer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;

    public void sendMapMessage() throws JMSException {
        MapMessage map = new ActiveMQMapMessage();
        map.setString("time", new Date().toString());
        map.setString("type", "map");
        jmsMessagingTemplate.convertAndSend(this.queue, map);
    }

    public void sendMapMessageFilterRed() throws JMSException {
        MapMessage map = new ActiveMQMapMessage();
        map.setStringProperty("color", "red");
        map.setString("time", new Date().toString());
        map.setString("type", "map");
        jmsMessagingTemplate.convertAndSend(this.queue, map);
    }

    public void sendMapMessageFilterGreen() throws JMSException {
        MapMessage map = new ActiveMQMapMessage();
        map.setStringProperty("color", "Green");
        map.setString("time", new Date().toString());
        map.setString("type", "map");
        jmsMessagingTemplate.convertAndSend(this.queue, map);
    }
}
