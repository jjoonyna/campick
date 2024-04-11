package com.choongang.campick;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
@EnableScheduling
@SpringBootApplication
public class CampickTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampickTestApplication.class, args);
	}

}
