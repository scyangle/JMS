package com.example.activemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import java.util.Map;

/**
 * Description:
 *
 * @author shichengyao
 * @Date 2017/11/30
 */
@Component
public class ActiveMqConsumer {
    @JmsListener(destination = "sample.queue")
    public void receiveQueue(Message message) throws JMSException {
        MapMessage map = (MapMessage) message;
        System.out.println(map.getString("time"));
        System.out.println(map.getString("type"));
        System.out.println(map.toString());
    }
}
