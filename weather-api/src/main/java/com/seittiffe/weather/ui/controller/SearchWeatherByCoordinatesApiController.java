package com.seittiffe.weather.ui.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.seittiffe.weather.service.WeatherByCoordinatesService;
import com.seittiffe.weather.ui.model.WeatherResponse;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-05T15:30:51.630808200-04:00[America/Santiago]")
@Controller
@RequestMapping("${openapi.weatherApiOas.base-path:}")
public class SearchWeatherByCoordinatesApiController implements SearchWeatherByCoordinatesApi {

	private WeatherByCoordinatesService weatherByCoordinatesService;

	public SearchWeatherByCoordinatesApiController(WeatherByCoordinatesService weatherByCoordinatesService,
			RestTemplate restTemplate) {
		this.weatherByCoordinatesService = weatherByCoordinatesService;

	}

	@Override
	public ResponseEntity<WeatherResponse> searchByCoordinates(@NotNull @Valid BigDecimal latitude, @NotNull @Valid BigDecimal longitude, @NotNull @Valid String metric) throws UnsupportedEncodingException {
		return weatherByCoordinatesService.getWeatherByCoordinates(latitude, longitude, metric);
	}

}
