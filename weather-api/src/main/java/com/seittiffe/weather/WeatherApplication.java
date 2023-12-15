package com.seittiffe.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class WeatherApplication {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path","/v1");
		SpringApplication.run(WeatherApplication.class, args);
	}

}
