package com.example.exercice03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin("*")
public class Exercice03Application {

	public static void main(String[] args) {
		SpringApplication.run(Exercice03Application.class, args);
	}

}
