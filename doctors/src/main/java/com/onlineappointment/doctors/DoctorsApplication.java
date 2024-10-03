package com.onlineappointment.doctors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.onlineappointment")
@EnableDiscoveryClient
public class DoctorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorsApplication.class, args);
	}

}
