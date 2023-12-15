package com.cristianreyesad.newsapi.config;

import com.cristianreyesad.newsapi.util.IsNumber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    //Creamos un java bean para que se manejen dentro de toda la aplicación
    @Bean
    RestTemplate restTemplate() { return new RestTemplate(); }

    @Bean
    StringBuilder stringBuilder() { return new StringBuilder(); }

    @Bean
    IsNumber isNumber() { return new IsNumber(); }
}
