package com.example.activemq;

import com.example.activemq.producer.ActiveMqProducer;
import com.example.activemq.producer.VirtualColorProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;


@SpringBootApplication
@EnableJms
public class ActivemqApplication implements CommandLineRunner {
    @Autowired
    private ActiveMqProducer activeMqProducer;

    @Autowired
    private VirtualColorProducer virtualColorProducer;

    @Override
    public void run(String... strings) throws Exception {
		//<editor-fold desc="sample.queue">
		for (int i=0;i<100;i++) {
			activeMqProducer.sendMapMessage();
			activeMqProducer.sendMapMessageFilterGreen();
			activeMqProducer.sendMapMessageFilterRed();
		}
		//</editor-fold>

        //<editor-fold desc="VirtualTopicColor">
        for (int i = 0; i < 100; i++) {
            virtualColorProducer.sendTopicColorMessage(String.valueOf(i));
        }
        //</editor-fold>
    }

    public static void main(String[] args) {
        SpringApplication.run(ActivemqApplication.class, args);
    }
}
