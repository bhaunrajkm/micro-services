package com.bhanu.currecnyconversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CurrecnyConversionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrecnyConversionApplication.class, args);
	}

}
