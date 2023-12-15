package com.seittiffe.weather.util;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class WeatherURLFactory {

	private final Environment environment;
	private StringBuilder urlBuilder;

	public WeatherURLFactory(Environment environment, StringBuilder urlBuilder) {
		this.environment = environment;
		this.urlBuilder = urlBuilder;
	}

	public String getUrl(BigDecimal lat, BigDecimal lon, String unit) {
		if (urlBuilder != null) {
			urlBuilder = new StringBuilder();
		}
		urlBuilder.append(environment.getProperty("open-weather.host"));
		urlBuilder.append(environment.getProperty("open-weather.data")).append("/");
		urlBuilder.append(environment.getProperty("open-weather.version")).append("/");
		urlBuilder.append(environment.getProperty("open-weather.operationId")).append("?");
		urlBuilder.append(environment.getProperty("open-weather.lat")).append("=").append(lat).append("&");
		urlBuilder.append(environment.getProperty("open-weather.lon")).append("=").append(lon).append("&");
		urlBuilder.append(environment.getProperty("open-weather.unit")).append("=").append(unit).append("&");
		urlBuilder.append(environment.getProperty("open-weather.key")).append("=");
		urlBuilder.append(environment.getProperty("open-weather.apikey"));
		return urlBuilder.toString().trim().toLowerCase();
	}

	public String getCoordinates(String q, BigDecimal limit) {
		if (urlBuilder != null) {
			urlBuilder = new StringBuilder();
		}
		urlBuilder.append(environment.getProperty("open-weather.host"));
		urlBuilder.append(environment.getProperty("geo-location.operationId")).append("/");
		urlBuilder.append(environment.getProperty("geo-location.version")).append("/");
		urlBuilder.append(environment.getProperty("geo-location.direct")).append("?");
		urlBuilder.append(environment.getProperty("geo-location.city-name")).append("=").append(q).append("&");
		urlBuilder.append(environment.getProperty("geo-location.limit")).append("=").append(limit).append("&");
		urlBuilder.append(environment.getProperty("open-weather.key")).append("=");
		urlBuilder.append(environment.getProperty("open-weather.apikey"));
		return urlBuilder.toString().trim().toLowerCase();
	}
}
