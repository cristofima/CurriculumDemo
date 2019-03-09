package com.coronado.cv;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CurriculumApplication {

	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC-5"));
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CurriculumApplication.class, args);
	}
}
