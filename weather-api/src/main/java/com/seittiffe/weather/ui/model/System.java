package com.seittiffe.weather.ui.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * System general information
 */

@Schema(name = "System", description = "System general information")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-05T15:30:51.630808200-04:00[America/Santiago]")
public class System {

	private BigDecimal type;

	private BigDecimal id;

	private String country;

	private BigDecimal sunrise;

	private BigDecimal sunset;

	public System type(BigDecimal type) {
		this.type = type;
		return this;
	}

	/**
	 * Get type
	 * 
	 * @return type
	 */
	@Valid
	@Schema(name = "type", example = "1", required = false)
	@JsonProperty("type")
	public BigDecimal getType() {
		return type;
	}

	public void setType(BigDecimal type) {
		this.type = type;
	}

	public System id(BigDecimal id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 */
	@Valid
	@Schema(name = "id", example = "7597", required = false)
	@JsonProperty("id")
	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public System country(String country) {
		this.country = country;
		return this;
	}

	/**
	 * Get country
	 * 
	 * @return country
	 */

	@Schema(name = "country", example = "IQ", required = false)
	@JsonProperty("country")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public System sunrise(BigDecimal sunrise) {
		this.sunrise = sunrise;
		return this;
	}

	/**
	 * Get sunrise
	 * 
	 * @return sunrise
	 */
	@Valid
	@Schema(name = "sunrise", example = "1680662717", required = false)
	@JsonProperty("sunrise")
	public BigDecimal getSunrise() {
		return sunrise;
	}

	public void setSunrise(BigDecimal sunrise) {
		this.sunrise = sunrise;
	}

	public System sunset(BigDecimal sunset) {
		this.sunset = sunset;
		return this;
	}

	/**
	 * Get sunset
	 * 
	 * @return sunset
	 */
	@Valid
	@Schema(name = "sunset", example = "1680662717", required = false)
	@JsonProperty("sunset")
	public BigDecimal getSunset() {
		return sunset;
	}

	public void setSunset(BigDecimal sunset) {
		this.sunset = sunset;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		System system = (System) o;
		return Objects.equals(this.type, system.type) && Objects.equals(this.id, system.id)
				&& Objects.equals(this.country, system.country) && Objects.equals(this.sunrise, system.sunrise)
				&& Objects.equals(this.sunset, system.sunset);
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, id, country, sunrise, sunset);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class System {\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    country: ").append(toIndentedString(country)).append("\n");
		sb.append("    sunrise: ").append(toIndentedString(sunrise)).append("\n");
		sb.append("    sunset: ").append(toIndentedString(sunset)).append("\n");
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
