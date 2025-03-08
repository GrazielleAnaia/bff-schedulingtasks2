package com.grazielleanaia.bff_schedulingtasks2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BffSchedulingtasks2Application {

	public static void main(String[] args) {
		SpringApplication.run(BffSchedulingtasks2Application.class, args);
	}

}
