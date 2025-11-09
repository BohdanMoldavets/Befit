package com.moldavets.befit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BefitApplication {

	public static void main(String[] args) {
		SpringApplication.run(BefitApplication.class, args);
	}

}
