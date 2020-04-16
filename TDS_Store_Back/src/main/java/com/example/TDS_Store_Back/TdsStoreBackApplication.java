package com.example.TDS_Store_Back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class TdsStoreBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(TdsStoreBackApplication.class, args);
	}

}
