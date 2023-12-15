package com.seittiffe.weather.ui.controller;

import javax.annotation.Generated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seittiffe.weather.service.WeatherVersionService;
import com.seittiffe.weather.ui.model.VersionResponse;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-05T15:30:51.630808200-04:00[America/Santiago]")
@Controller
@RequestMapping("${openapi.weatherApiOas.base-path:}")
public class VersionApiController implements VersionApi {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(VersionApiController.class); 

	private WeatherVersionService weatherVersionService;

	public VersionApiController(WeatherVersionService weatherVersionService) {
		this.weatherVersionService = weatherVersionService;
	}

	@Override
	public ResponseEntity<VersionResponse> getVersion() {
		LOGGER.info(weatherVersionService.getVersion().getBody().getVersion().toString());
		return weatherVersionService.getVersion();
	}
}
