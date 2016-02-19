package com.demoapp.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.demoapp.service.CompanyService;
import com.demoapp.service.CompanyServiceImpl;
import com.demoapp.service.OwnerService;
import com.demoapp.service.OwnerServiceImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.demoapp")
@EnableAutoConfiguration
@PropertySource(value = { "classpath:application.properties" })
public class DemoAppConfiguration {
	
	@Bean
	public CompanyService getCompanyService(){
		return new CompanyServiceImpl();
	}
	
	@Bean
	public OwnerService getOwnerService(){
		return new OwnerServiceImpl();
	}


	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer()
	{
		return new PropertySourcesPlaceholderConfigurer();
	}

}
