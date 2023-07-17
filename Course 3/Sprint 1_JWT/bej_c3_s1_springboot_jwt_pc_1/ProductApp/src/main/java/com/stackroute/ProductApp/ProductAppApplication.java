package com.stackroute.ProductApp;

import com.stackroute.ProductApp.Filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductAppApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean jwtFilter(){
		FilterRegistrationBean frb=new FilterRegistrationBean();
		frb.setFilter(new JwtFilter());
		frb.addUrlPatterns("/get-user-details","/add-products");
		return frb;
	}

}
