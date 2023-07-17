package com.stackroute.AuthenticationApp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication @EnableEurekaClient  @EnableFeignClients
public class AuthenticationAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationAppApplication.class, args);

	}
	//Intercepted Url is accessible by FilterRegistrationBean


}
