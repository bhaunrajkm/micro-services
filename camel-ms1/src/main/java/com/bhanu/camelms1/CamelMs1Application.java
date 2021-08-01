package com.bhanu.camelms1;

import org.apache.camel.component.activemq.ActiveMQComponent;
import org.apache.camel.component.kafka.KafkaComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.jms.ConnectionFactory;

@SpringBootApplication
public class CamelMs1Application {

	public static void main(String[] args) {
		SpringApplication.run(CamelMs1Application.class, args);
	}

	@Bean(name = "activemq")
	public ActiveMQComponent createComponent(ConnectionFactory factory) {
		ActiveMQComponent activeMQComponent = new ActiveMQComponent();
		activeMQComponent.setConnectionFactory(factory);
		return activeMQComponent;
	}

	@Bean(name = "kafka")
	public KafkaComponent createComponentKafka(ConnectionFactory factory) {
		KafkaComponent kafkaComponent = new KafkaComponent();
//		activeMQComponent.setConnectionFactory(factory);
		return kafkaComponent;
	}
}
