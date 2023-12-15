package com.seittiffe.weather.mapper;

import com.seittiffe.weather.ui.model.GeoLocationInformationGeolocationArrayInner;

public interface MapGeoLocationResponseService {

	GeoLocationInformationGeolocationArrayInner map(String jsonResponse);
}
