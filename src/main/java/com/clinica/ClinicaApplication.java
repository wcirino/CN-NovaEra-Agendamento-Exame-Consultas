package com.clinica;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient
@EnableFeignClients
@EnableRabbit
public class ClinicaApplication{

	public static void main(String[] args) {
		SpringApplication.run(ClinicaApplication.class, args);
	}

}

//public class ClinicaApplication extends SpringBootServletInitializer {
//
//	public static void main(String[] args) {
//		SpringApplication.run(ClinicaApplication.class, args);
//	}
//
//}
