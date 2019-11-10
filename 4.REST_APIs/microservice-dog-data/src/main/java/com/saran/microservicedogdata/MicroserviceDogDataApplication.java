package com.saran.microservicedogdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceDogDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceDogDataApplication.class, args);
	}

}
