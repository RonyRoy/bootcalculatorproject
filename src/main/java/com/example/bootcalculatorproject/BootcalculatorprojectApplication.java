package com.example.bootcalculatorproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BootcalculatorprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootcalculatorprojectApplication.class, args);
	}

}
