package com.seittiffe.weather.service;

import org.springframework.http.ResponseEntity;

import com.seittiffe.weather.ui.model.HealthCheckResponse;

public interface WeatherHealthCheckService {

	public ResponseEntity<HealthCheckResponse> getStatus();

}
