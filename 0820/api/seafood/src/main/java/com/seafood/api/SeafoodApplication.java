package com.seafood.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author eason
 */
@SpringBootApplication
@RestController
public class SeafoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeafoodApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello() {
		return "helloworld";
	}

}
