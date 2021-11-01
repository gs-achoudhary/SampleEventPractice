package com.abhi.practice.SpringPractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitTemplateConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class SpringPracticeApplication {

	public static void main(String[] args) throws Exception {

		ApplicationContext context = SpringApplication.run(SpringPracticeApplication.class, args);
		CustomSpringEventPublisher customSpringEventPublisher = (CustomSpringEventPublisher) context.getBean("customSpringEventPublisher");

		customSpringEventPublisher.publishCustomEvent(new CustomSpringEvent(new EventSource(), "firstMessage"));

		TimeUnit.SECONDS.sleep(10);
	}
}
