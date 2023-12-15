package com.seittiffe.weather.ui.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seittiffe.weather.service.WeatherByGeolocationService;
import com.seittiffe.weather.ui.model.WeatherResponse;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-05T15:30:51.630808200-04:00[America/Santiago]")
@Controller
@RequestMapping("${openapi.weatherApiOas.base-path:}")
public class SearchWeatherByGeolocationApiController implements SearchWeatherByGeolocationApi {

	private WeatherByGeolocationService weatherByGeolocationService;

	public SearchWeatherByGeolocationApiController(WeatherByGeolocationService weatherByGeolocationService) {
		this.weatherByGeolocationService = weatherByGeolocationService;
	}

	@Override
	public ResponseEntity<WeatherResponse> searchByGeolocation(@NotNull @Valid String city, @NotNull @Valid BigDecimal limit, @NotNull @Valid String unit) throws UnsupportedEncodingException {
		return weatherByGeolocationService.getWeatherByGeoLocation(city, limit, unit);
	}

}
