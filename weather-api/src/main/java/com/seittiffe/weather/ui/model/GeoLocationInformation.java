package com.seittiffe.weather.ui.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Geolocation information of the City
 */

@Schema(name = "geoLocationInformation", description = "Geolocation information of the City")
@JsonTypeName("geoLocationInformation")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-06T11:39:02.674195600-04:00[America/Santiago]")
public class GeoLocationInformation {

	@Valid
	private List<@Valid GeoLocationInformationGeolocationArrayInner> geolocationArray;

	public GeoLocationInformation geolocationArray(
			List<@Valid GeoLocationInformationGeolocationArrayInner> geolocationArray) {
		this.geolocationArray = geolocationArray;
		return this;
	}

	public GeoLocationInformation addGeolocationArrayItem(
			GeoLocationInformationGeolocationArrayInner geolocationArrayItem) {
		if (this.geolocationArray == null) {
			this.geolocationArray = new ArrayList<>();
		}
		this.geolocationArray.add(geolocationArrayItem);
		return this;
	}

	/**
	 * Get geolocationArray
	 * 
	 * @return geolocationArray
	 */
	@Valid
	@Schema(name = "geolocationArray", required = false)
	@JsonProperty("geolocationArray")
	public List<@Valid GeoLocationInformationGeolocationArrayInner> getGeolocationArray() {
		return geolocationArray;
	}

	public void setGeolocationArray(List<@Valid GeoLocationInformationGeolocationArrayInner> geolocationArray) {
		this.geolocationArray = geolocationArray;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		GeoLocationInformation geoLocationInformation = (GeoLocationInformation) o;
		return Objects.equals(this.geolocationArray, geoLocationInformation.geolocationArray);
	}

	@Override
	public int hashCode() {
		return Objects.hash(geolocationArray);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class GeoLocationInformation {\n");
		sb.append("    geolocationArray: ").append(toIndentedString(geolocationArray)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
