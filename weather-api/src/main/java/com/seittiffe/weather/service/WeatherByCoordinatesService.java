package com.seittiffe.weather.service;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;

import com.seittiffe.weather.ui.model.WeatherResponse;

public interface WeatherByCoordinatesService {

	public ResponseEntity<WeatherResponse> getWeatherByCoordinates(BigDecimal lat, BigDecimal lon, String unit) throws UnsupportedEncodingException;

}
