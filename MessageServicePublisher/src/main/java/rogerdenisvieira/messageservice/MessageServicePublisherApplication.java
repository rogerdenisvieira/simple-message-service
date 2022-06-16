package rogerdenisvieira.messageservice;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class MessageServicePublisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageServicePublisherApplication.class, args);
	}

}
