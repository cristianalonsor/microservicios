package com.seittiffe.weather.service.impl;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.seittiffe.weather.mapper.MapGeoLocationResponseService;
import com.seittiffe.weather.service.WeatherByGeolocationService;
import com.seittiffe.weather.ui.model.GeoLocationInformation;
import com.seittiffe.weather.ui.model.GeoLocationInformationGeolocationArrayInner;
import com.seittiffe.weather.ui.model.WeatherResponse;
import com.seittiffe.weather.util.WeatherURLFactory;

@Service
public class WeatherByGeolocationServiceImpl implements WeatherByGeolocationService {

	private final static Logger LOGGER = LoggerFactory.getLogger(WeatherByGeolocationServiceImpl.class);

	private RestTemplate restTemplate;
	private WeatherURLFactory weatherURLFactory;
	private MapGeoLocationResponseService mapGeoLocationResponseService;

	public WeatherByGeolocationServiceImpl(RestTemplate restTemplate, WeatherURLFactory weatherURLFactory, MapGeoLocationResponseService mapGeoLocationResponseService) {
		this.restTemplate = restTemplate;
		this.weatherURLFactory = weatherURLFactory;
		this.mapGeoLocationResponseService = mapGeoLocationResponseService;
	}

	@Override
	public ResponseEntity<WeatherResponse> getWeatherByGeoLocation(String city, BigDecimal limit, String unit) throws UnsupportedEncodingException {
		GeoLocationInformationGeolocationArrayInner geoLocationInformationInnerArray = new GeoLocationInformationGeolocationArrayInner();
		GeoLocationInformation geoLocationInformation = new GeoLocationInformation();

		String jsonResponse = restTemplate.getForObject(weatherURLFactory.getCoordinates(city, limit), String.class);

		geoLocationInformationInnerArray = mapGeoLocationResponseService.map(jsonResponse);
		geoLocationInformation.addGeolocationArrayItem(geoLocationInformationInnerArray);

		BigDecimal latitude = new BigDecimal(0.0);
		BigDecimal longitude = new BigDecimal(0.0);

		for (@Valid GeoLocationInformationGeolocationArrayInner itr : geoLocationInformation.getGeolocationArray()) {
			latitude = itr.getLat();
			longitude = itr.getLon();
		}

		WeatherResponse weatherResponse = restTemplate.getForObject(weatherURLFactory.getUrl(latitude, longitude, unit), WeatherResponse.class);
		LOGGER.info(weatherResponse.getName());
		return ResponseEntity.ok(weatherResponse);

	}

}
