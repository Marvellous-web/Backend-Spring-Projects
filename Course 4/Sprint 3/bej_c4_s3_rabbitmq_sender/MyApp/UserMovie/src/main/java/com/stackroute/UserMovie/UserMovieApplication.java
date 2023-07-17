package com.stackroute.UserMovie;

import com.stackroute.UserMovie.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserMovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserMovieApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean jwtFilter(){
		FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new JwtFilter());
		filterRegistrationBean.addUrlPatterns("/movieApp/getUserByEmail","/movieApp/addMovieByEmail");
		return filterRegistrationBean;

	}

}
