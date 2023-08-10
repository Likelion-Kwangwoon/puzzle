package com.puzzle.likelion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
@SpringBootApplication
public class LikelionApplication {

	public static void main(String[] args) {
		SpringApplication.run(LikelionApplication.class, args);
	}

}
