package com.example.SpringMC1;

import com.example.SpringMC1.service.MessageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringMc1Application {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(SpringMc1Application.class, args);
//		MessageService ms=context.getBean("messageService", MessageService.class);
		//or
		MessageService ms=(MessageService)context.getBean("messageService");
		System.out.println(ms.getMessage());
	}

}
