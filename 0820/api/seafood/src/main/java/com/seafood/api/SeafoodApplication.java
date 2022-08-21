package com.seafood.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping(value = "/hello")
	public String hello(@RequestParam(name = "query", required = false) String query) {
		if (!StringUtils.hasLength(query)) {
			query = "helloworld";
		}
		return "query=" + query;
	}

}
