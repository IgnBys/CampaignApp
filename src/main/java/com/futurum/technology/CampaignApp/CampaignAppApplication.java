package com.futurum.technology.CampaignApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories

@SpringBootApplication
public class CampaignAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampaignAppApplication.class, args);
	}

}
