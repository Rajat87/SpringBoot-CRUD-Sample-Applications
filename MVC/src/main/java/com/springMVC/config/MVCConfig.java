package com.springMVC.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


// This is the Spring MVC configuration file 
@Configuration
@ComponentScan({"com.springMVC.*"})
public class MVCConfig {
	// How is this method executed when I am not creating an application context in my Home Controller or in any other class. 
	@Bean
	public InternalResourceViewResolver givesViewResolver() {
		InternalResourceViewResolver irv = new InternalResourceViewResolver();
		System.out.println("Inside View Resolver Method");
		irv.setPrefix("/WEB-INF/");
		irv.setSuffix(".jsp");
		return irv;
	}

}
