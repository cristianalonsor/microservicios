package com.seittiffe.weather.mapper.impl;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seittiffe.weather.mapper.MapGeoLocationResponseService;
import com.seittiffe.weather.ui.model.GeoLocationInformationGeolocationArrayInner;

@Service
public class MapGeoLocationResponseServiceImpl implements MapGeoLocationResponseService {

	private ObjectMapper objectMapper;

	public MapGeoLocationResponseServiceImpl(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@Override
	public GeoLocationInformationGeolocationArrayInner map(String jsonResponse) {

		try {
			jsonResponse = jsonResponse.replace("[", "").replace("]", "");
			GeoLocationInformationGeolocationArrayInner arrayInners = objectMapper.readValue(jsonResponse,
					GeoLocationInformationGeolocationArrayInner.class);
			return arrayInners;
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

}
