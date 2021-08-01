package com.bhanu.camelms2;

import org.apache.camel.component.kafka.KafkaComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.jms.ConnectionFactory;

@SpringBootApplication
public class CamelMs2Application {

	public static void main(String[] args) {
		SpringApplication.run(CamelMs2Application.class, args);
	}

	@Bean(name = "kafka")
	public KafkaComponent createComponentKafka(ConnectionFactory factory) {
		KafkaComponent kafkaComponent = new KafkaComponent();
		return kafkaComponent;
	}
}
