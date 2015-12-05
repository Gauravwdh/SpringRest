package com.gaurav.springrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
				"spring.xml");
		Object bean = classPathXmlApplicationContext.getBean("userDao");
		System.out.println("Bean created atthis" + bean);
		SpringApplication.run(Application.class, args);
	}
}
