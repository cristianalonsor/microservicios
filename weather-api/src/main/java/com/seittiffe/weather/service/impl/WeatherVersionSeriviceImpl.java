package com.seittiffe.weather.service.impl;

import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.seittiffe.weather.service.WeatherVersionService;
import com.seittiffe.weather.ui.model.VersionResponse;

@Service
public class WeatherVersionSeriviceImpl implements WeatherVersionService {

	private Environment environment;

	public WeatherVersionSeriviceImpl(Environment environment) {
		this.environment = environment;
	}

	@Override
	public ResponseEntity<VersionResponse> getVersion() {
		VersionResponse versionResponse = new VersionResponse(environment.getProperty("api.name"), environment.getProperty("api.version"));
		return ResponseEntity.ok(versionResponse);
	}

}
