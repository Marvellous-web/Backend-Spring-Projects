package com.example.SpringDemo;

import com.example.SpringDemo.service.OperationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(SpringDemoApplication.class, args);
		OperationService os=context.getBean("operationService", OperationService.class);
		System.out.println("The sum is ");
		System.out.println(os.add(2,3));
	}

}
