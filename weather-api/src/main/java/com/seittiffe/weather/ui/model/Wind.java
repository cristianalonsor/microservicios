package com.seittiffe.weather.ui.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Wind information
 */

@Schema(name = "Wind", description = "Wind information")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-05T15:30:51.630808200-04:00[America/Santiago]")
public class Wind {

	private BigDecimal speed;

	private BigDecimal deg;

	private BigDecimal gust;

	public Wind speed(BigDecimal speed) {
		this.speed = speed;
		return this;
	}

	/**
	 * Get speed
	 * 
	 * @return speed
	 */
	@Valid
	@Schema(name = "speed", example = "5.03", required = false)
	@JsonProperty("speed")
	public BigDecimal getSpeed() {
		return speed;
	}

	public void setSpeed(BigDecimal speed) {
		this.speed = speed;
	}

	public Wind deg(BigDecimal deg) {
		this.deg = deg;
		return this;
	}

	/**
	 * Get deg
	 * 
	 * @return deg
	 */
	@Valid
	@Schema(name = "deg", example = "137", required = false)
	@JsonProperty("deg")
	public BigDecimal getDeg() {
		return deg;
	}

	public void setDeg(BigDecimal deg) {
		this.deg = deg;
	}

	public Wind gust(BigDecimal gust) {
		this.gust = gust;
		return this;
	}

	/**
	 * Get gust
	 * 
	 * @return gust
	 */
	@Valid
	@Schema(name = "gust", example = "8.95", required = false)
	@JsonProperty("gust")
	public BigDecimal getGust() {
		return gust;
	}

	public void setGust(BigDecimal gust) {
		this.gust = gust;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Wind wind = (Wind) o;
		return Objects.equals(this.speed, wind.speed) && Objects.equals(this.deg, wind.deg)
				&& Objects.equals(this.gust, wind.gust);
	}

	@Override
	public int hashCode() {
		return Objects.hash(speed, deg, gust);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Wind {\n");
		sb.append("    speed: ").append(toIndentedString(speed)).append("\n");
		sb.append("    deg: ").append(toIndentedString(deg)).append("\n");
		sb.append("    gust: ").append(toIndentedString(gust)).append("\n");
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
