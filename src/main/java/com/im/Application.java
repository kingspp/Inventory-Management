package com.im;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@Configuration
@ComponentScan( basePackages = "com.im" )
@EnableTransactionManagement
public class Application {

    // private static final Logger LOG =
    // LoggerFactory.getLogger(Application.class);

    public static void main( String[] args ) throws Exception
    {
        SpringApplication.run(Application.class, args);
    }

}
