package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ComponentScan(basePackages={"com.controllers"})
@ComponentScan(basePackages={"com.models"})
@ComponentScan(basePackages={"com.repository"})
@ComponentScan(basePackages={"it.ozimov.springboot"})
@EnableAsync
@EnableJpaRepositories
public class EventstsxApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventstsxApplication.class, args);
	}

}
