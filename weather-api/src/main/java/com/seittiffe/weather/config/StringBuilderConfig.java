package com.seittiffe.weather.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StringBuilderConfig {

	@Bean
	StringBuilder stringBuilder() {
		return new StringBuilder();
	}
}
