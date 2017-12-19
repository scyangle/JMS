package com.example.activemq.consumer;

import org.apache.activemq.command.ActiveMQMapMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;

/**
 * Description:
 *
 * @author shichengyao
 * @Date 2017/12/19
 */
@Component
public class VirtualColorConsumer {
    @JmsListener(destination = "Consumer.A.VirtualTopic.color")
    public void consumerColorA(Message msg) throws JMSException {
        if (msg instanceof ActiveMQMapMessage) {
            MapMessage mapMessage = (MapMessage) msg;
            String color = mapMessage.getString("color");
            String typeName = mapMessage.getString("typeName");
            String id = mapMessage.getString("id");
            System.out.println("VirtualTopic.colorA"+" : id= "+id+" color= "+color+" typeName= "+typeName);
        }
        else{
            System.out.println(msg);
        }
    }

    @JmsListener(destination = "Consumer.B.VirtualTopic.color")
    public void consumerColorB(Message msg) throws JMSException {
        if (msg instanceof ActiveMQMapMessage) {
            MapMessage mapMessage = (MapMessage) msg;
            String color = mapMessage.getString("color");
            String typeName = mapMessage.getString("typeName");
            String id = mapMessage.getString("id");
            System.out.println("VirtualTopic.colorB"+" : id= "+id+" color= "+color+" typeName= "+typeName);
        }
        else{
            System.out.println(msg);
        }
    }
}
