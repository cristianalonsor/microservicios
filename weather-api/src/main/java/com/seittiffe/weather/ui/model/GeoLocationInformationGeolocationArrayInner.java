package com.seittiffe.weather.ui.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * GeoLocationInformationGeolocationArrayInner
 */

@JsonTypeName("geoLocationInformation_geolocationArray_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-06T11:39:02.674195600-04:00[America/Santiago]")
public class GeoLocationInformationGeolocationArrayInner {

	private String name;

	private GeoLocationInformationGeolocationArrayInnerLocalNames local_names;

	private BigDecimal lat;

	private BigDecimal lon;

	private String country;

	private String state;

	public GeoLocationInformationGeolocationArrayInner name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Get name
	 * 
	 * @return name
	 */

	@Schema(name = "name", example = "Santiago", required = false)
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GeoLocationInformationGeolocationArrayInner localNames(
			GeoLocationInformationGeolocationArrayInnerLocalNames localNames) {
		this.local_names = localNames;
		return this;
	}

	/**
	 * Get localNames
	 * 
	 * @return localNames
	 */
	@Valid
	@Schema(name = "local_names", required = false)
	@JsonProperty("local_names")
	public GeoLocationInformationGeolocationArrayInnerLocalNames getLocalNames() {
		return local_names;
	}

	public void setLocalNames(GeoLocationInformationGeolocationArrayInnerLocalNames localNames) {
		this.local_names = localNames;
	}

	public GeoLocationInformationGeolocationArrayInner lat(BigDecimal lat) {
		this.lat = lat;
		return this;
	}

	/**
	 * Get lat
	 * 
	 * @return lat
	 */
	@Valid
	@Schema(name = "lat", example = "33.33", required = false)
	@JsonProperty("lat")
	public BigDecimal getLat() {
		return lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	public GeoLocationInformationGeolocationArrayInner lon(BigDecimal lon) {
		this.lon = lon;
		return this;
	}

	/**
	 * Get lon
	 * 
	 * @return lon
	 */
	@Valid
	@Schema(name = "lon", example = "44.44", required = false)
	@JsonProperty("lon")
	public BigDecimal getLon() {
		return lon;
	}

	public void setLon(BigDecimal lon) {
		this.lon = lon;
	}

	public GeoLocationInformationGeolocationArrayInner country(String country) {
		this.country = country;
		return this;
	}

	/**
	 * Get country
	 * 
	 * @return country
	 */

	@Schema(name = "country", example = "CL", required = false)
	@JsonProperty("country")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public GeoLocationInformationGeolocationArrayInner state(String state) {
		this.state = state;
		return this;
	}

	/**
	 * Get state
	 * 
	 * @return state
	 */

	@Schema(name = "state", example = "Santiago", required = false)
	@JsonProperty("state")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		GeoLocationInformationGeolocationArrayInner geoLocationInformationGeolocationArrayInner = (GeoLocationInformationGeolocationArrayInner) o;
		return Objects.equals(this.name, geoLocationInformationGeolocationArrayInner.name)
				&& Objects.equals(this.local_names, geoLocationInformationGeolocationArrayInner.local_names)
				&& Objects.equals(this.lat, geoLocationInformationGeolocationArrayInner.lat)
				&& Objects.equals(this.lon, geoLocationInformationGeolocationArrayInner.lon)
				&& Objects.equals(this.country, geoLocationInformationGeolocationArrayInner.country)
				&& Objects.equals(this.state, geoLocationInformationGeolocationArrayInner.state);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, local_names, lat, lon, country, state);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class GeoLocationInformationGeolocationArrayInner {\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    localNames: ").append(toIndentedString(local_names)).append("\n");
		sb.append("    lat: ").append(toIndentedString(lat)).append("\n");
		sb.append("    lon: ").append(toIndentedString(lon)).append("\n");
		sb.append("    country: ").append(toIndentedString(country)).append("\n");
		sb.append("    state: ").append(toIndentedString(state)).append("\n");
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