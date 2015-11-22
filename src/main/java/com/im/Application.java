package com.im;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan( basePackages = "com.im" )
public class Application extends SpringBootServletInitializer {

	private static final Logger LOG = LoggerFactory.getLogger(Application.class);

	public static void main( String[] args ) throws Exception
	{
		SpringApplication.run(Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure( SpringApplicationBuilder application )
	{
		return application.sources(Application.class);
	}

}
