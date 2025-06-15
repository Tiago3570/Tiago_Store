package com.example.TDS_Store_Back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TdsStoreBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(TdsStoreBackApplication.class, args);
	}

}
