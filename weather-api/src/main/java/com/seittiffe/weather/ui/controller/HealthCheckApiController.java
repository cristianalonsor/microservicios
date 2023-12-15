package com.seittiffe.weather.ui.controller;

import javax.annotation.Generated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seittiffe.weather.service.WeatherHealthCheckService;
import com.seittiffe.weather.ui.model.HealthCheckResponse;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-05T15:30:51.630808200-04:00[America/Santiago]")
@Controller
@RequestMapping("${openapi.weatherApiOas.base-path:}")
public class HealthCheckApiController implements HealthCheckApi {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(HealthCheckApiController.class); 

	private final WeatherHealthCheckService weatherHealthCheckService;

	public HealthCheckApiController(WeatherHealthCheckService weatherHealthCheckService) {
		this.weatherHealthCheckService = weatherHealthCheckService;
	}

	@Override
	public ResponseEntity<HealthCheckResponse> getHealthCheck() {
		LOGGER.info(weatherHealthCheckService.getStatus().getStatusCode().toString());
		return weatherHealthCheckService.getStatus();
	}
}
