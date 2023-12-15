package com.seittiffe.weather.service.impl;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.seittiffe.weather.service.WeatherByCoordinatesService;
import com.seittiffe.weather.ui.model.WeatherResponse;
import com.seittiffe.weather.util.WeatherURLFactory;

@Service
public class WeatherByCoordinatesServiceImpl implements WeatherByCoordinatesService {

	private final static Logger LOGGER = LoggerFactory.getLogger(WeatherByCoordinatesServiceImpl.class);

	private RestTemplate restTemplate;
	private WeatherURLFactory weatherURLFactory;

	public WeatherByCoordinatesServiceImpl(RestTemplate restTemplate, WeatherURLFactory weatherURLFactory) {
		this.restTemplate = restTemplate;
		this.weatherURLFactory = weatherURLFactory;
	}

	@Override
	public ResponseEntity<WeatherResponse> getWeatherByCoordinates(BigDecimal lat, BigDecimal lon, String unit) throws UnsupportedEncodingException {
		WeatherResponse weatherResponse = restTemplate.getForObject(weatherURLFactory.getUrl(lat, lon, unit), WeatherResponse.class);
		LOGGER.info(weatherResponse.getName());
		return ResponseEntity.ok(weatherResponse);
	}

}
