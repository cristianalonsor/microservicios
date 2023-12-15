package com.seittiffe.weather.service;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;

import com.seittiffe.weather.ui.model.WeatherResponse;

public interface WeatherByGeolocationService {

	public ResponseEntity<WeatherResponse> getWeatherByGeoLocation(String city, BigDecimal limit, String unit) throws UnsupportedEncodingException;

}
