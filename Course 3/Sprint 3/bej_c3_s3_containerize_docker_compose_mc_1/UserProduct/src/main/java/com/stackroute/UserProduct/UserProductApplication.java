package com.stackroute.UserProduct;

import com.stackroute.UserProduct.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;


import javax.servlet.FilterRegistration;

@SpringBootApplication
public class UserProductApplication {

	public static void main(String[] args) {

		SpringApplication.run(UserProductApplication.class, args);

	}
	@Bean
	public FilterRegistrationBean filterRegistrationBean(){
		FilterRegistrationBean frb=new FilterRegistrationBean<>();
		frb.setFilter(new JwtFilter());
		frb.addUrlPatterns("/get-login-user-details","/add-product-by-login-user");
		return frb;
	}

}
