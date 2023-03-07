package com.entgra.Task02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class Task02Application {

	public static void main(String[] args) {
		SpringApplication.run(Task02Application.class, args);
	}

}
