package com.clinica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
<<<<<<< HEAD
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
=======
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
>>>>>>> 7f989761c0f27fa99e080983e4d48c7906f22da2

@EnableWebMvc
@SpringBootApplication
<<<<<<< HEAD
//@EnableEurekaClient
=======
@EnableEurekaClient
>>>>>>> 7f989761c0f27fa99e080983e4d48c7906f22da2
public class ClinicaApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ClinicaApplication.class, args);
	}

}
