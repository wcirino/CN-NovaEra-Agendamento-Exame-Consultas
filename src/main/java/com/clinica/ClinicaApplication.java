package com.clinica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableWebMvc
@SpringBootApplication
//@EnableEurekaClient
@EnableEurekaClient
public class ClinicaApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ClinicaApplication.class, args);
	}

}
