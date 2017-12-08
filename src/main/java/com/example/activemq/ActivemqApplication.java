package com.example.activemq;

import com.example.activemq.producer.ActiveMqProducer;
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

	@Override
	public void run(String... strings) throws Exception {
		for (int i=0;i<100;i++) {
			activeMqProducer.sendMapMessage();
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(ActivemqApplication.class, args);
	}
}
