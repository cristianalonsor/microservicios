package com.seittiffe.weather.service;

import org.springframework.http.ResponseEntity;

import com.seittiffe.weather.ui.model.VersionResponse;

public interface WeatherVersionService {

	ResponseEntity<VersionResponse> getVersion();

}
