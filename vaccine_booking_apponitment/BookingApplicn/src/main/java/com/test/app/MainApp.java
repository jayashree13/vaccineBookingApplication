package com.test.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "com.test" })
@EnableJpaRepositories(basePackages = {
		"com.test" })
@EntityScan("com.test.model")
public class MainApp {
    public static void main(String [] args){
	SpringApplication.run(MainApp.class,args);

    }
}
