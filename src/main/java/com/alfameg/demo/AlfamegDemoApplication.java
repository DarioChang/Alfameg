package com.alfameg.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableJpaRepositories
@SpringBootApplication

public class AlfamegDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlfamegDemoApplication.class, args);
	}

}
