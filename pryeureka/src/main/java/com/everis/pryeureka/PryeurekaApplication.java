package com.everis.pryeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class PryeurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PryeurekaApplication.class, args);
	}

}
