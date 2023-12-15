package com.seittiffe.weather.ui.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Coordinates of the queried location
 */

@Schema(name = "Coordinates", description = "Coordinates of the queried location")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-05T15:30:51.630808200-04:00[America/Santiago]")
public class Coordinates {

	private BigDecimal lon;

	private BigDecimal lat;

	public Coordinates lon(BigDecimal lon) {
		this.lon = lon;
		return this;
	}

	/**
	 * Longitude of the queried location
	 * 
	 * @return lon
	 */
	@Valid
	@Schema(name = "lon", example = "44.44", description = "Longitude of the queried location", required = true)
	@JsonProperty("lon")
	public BigDecimal getLon() {
		return lon;
	}

	public void setLon(BigDecimal lon) {
		this.lon = lon;
	}

	public Coordinates lat(BigDecimal lat) {
		this.lat = lat;
		return this;
	}

	/**
	 * Latitude of the queried location
	 * 
	 * @return lat
	 */
	@Valid
	@Schema(name = "lat", example = "33.33", description = "Latitude of the queried location", required = true)
	@JsonProperty("lat")
	public BigDecimal getLat() {
		return lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Coordinates coordinates = (Coordinates) o;
		return Objects.equals(this.lon, coordinates.lon) && Objects.equals(this.lat, coordinates.lat);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lon, lat);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Coordinates {\n");
		sb.append("    lon: ").append(toIndentedString(lon)).append("\n");
		sb.append("    lat: ").append(toIndentedString(lat)).append("\n");
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
