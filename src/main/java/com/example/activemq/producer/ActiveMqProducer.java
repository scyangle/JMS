package com.example.activemq.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

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

    public void sendMapMessage() {
        Map map = new HashMap();
        map.put("time", new Date().toString());
        map.put("type", "map");
        this.jmsMessagingTemplate.convertAndSend(this.queue, map);
    }
}
