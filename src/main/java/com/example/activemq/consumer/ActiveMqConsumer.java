package com.example.activemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;

/**
 * Description:
 *
 * @author shichengyao
 * @Date 2017/11/30
 */
@Component
public class ActiveMqConsumer {
    @JmsListener(destination = "sample.queue",selector ="color = 'red'" )
    public void receiveQueueRed(Message message) throws JMSException {
        MapMessage map = (MapMessage) message;
        System.out.print(map.getString("time")+" : ");
        System.out.print(map.getString("type")+" : ");
        System.out.println(map.getStringProperty("color"));
    }

    @JmsListener(destination = "sample.queue",selector ="color = 'Green'" )
    public void receiveQueueGreen(Message message) throws JMSException {
        MapMessage map = (MapMessage) message;
        System.out.print(map.getString("time")+" : ");
        System.out.print(map.getString("type")+" : ");
        System.out.println(map.getStringProperty("color"));
    }
}
