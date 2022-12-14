package com.seafood.api;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author eason
 */
@SpringBootApplication
@MapperScan("com.seafood.api.mapper")
public class SeafoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeafoodApplication.class, args);
	}

}
