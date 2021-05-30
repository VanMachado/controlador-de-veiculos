package com.van.log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ControladorDeVeiculosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControladorDeVeiculosApplication.class, args);
	}

}
