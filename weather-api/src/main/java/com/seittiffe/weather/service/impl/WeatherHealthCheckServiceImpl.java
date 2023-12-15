package com.seittiffe.weather.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.seittiffe.weather.service.WeatherHealthCheckService;
import com.seittiffe.weather.ui.model.APIHealthStatus;
import com.seittiffe.weather.ui.model.APIProvider;
import com.seittiffe.weather.ui.model.Dependency;
import com.seittiffe.weather.ui.model.Dependency.StatusEnum;
import com.seittiffe.weather.ui.model.HealthCheckResponse;

@Service
public class WeatherHealthCheckServiceImpl implements WeatherHealthCheckService {

	private Environment environment;

	public WeatherHealthCheckServiceImpl(Environment environment) {
		this.environment = environment;
	}

	@Override
	public ResponseEntity<HealthCheckResponse> getStatus() {
		Dependency dependency = new Dependency(environment.getProperty("api.dependency.operation"), StatusEnum.UP);
		List<Dependency> dependencies = new ArrayList<Dependency>();
		dependencies.add(dependency);
		APIHealthStatus apiHealthStatus = new APIHealthStatus(dependencies);
		APIProvider apiProvider = new APIProvider(environment.getProperty("api.dependency.name"), apiHealthStatus);
		HealthCheckResponse healthCheckResponse = new HealthCheckResponse(environment.getProperty("api.name"),
				environment.getProperty("api.version"), apiProvider);
		return ResponseEntity.ok(healthCheckResponse);
	}

}
