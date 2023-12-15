package com.seittiffe.weather.ui.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Detailed weather description of the location
 */

@Schema(name = "Detailed_information", description = "Detailed weather description of the location")
@JsonTypeName("Detailed_information")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-05T15:30:51.630808200-04:00[America/Santiago]")
public class DetailedInformation {

	private BigDecimal temp;

	private BigDecimal feelsLike;

	private BigDecimal tempMin;

	private BigDecimal tempMax;

	private BigDecimal pressure;

	private BigDecimal humidity;

	private BigDecimal seaLevel;

	private BigDecimal grndLevel;

	public DetailedInformation temp(BigDecimal temp) {
		this.temp = temp;
		return this;
	}

	/**
	 * Get temp
	 * 
	 * @return temp
	 */
	@Valid
	@Schema(name = "temp", example = "28.7", required = false)
	@JsonProperty("temp")
	public BigDecimal getTemp() {
		return temp;
	}

	public void setTemp(BigDecimal temp) {
		this.temp = temp;
	}

	public DetailedInformation feelsLike(BigDecimal feelsLike) {
		this.feelsLike = feelsLike;
		return this;
	}

	/**
	 * Get feelsLike
	 * 
	 * @return feelsLike
	 */
	@Valid
	@Schema(name = "feels_like", example = "26.72", required = false)
	@JsonProperty("feels_like")
	public BigDecimal getFeelsLike() {
		return feelsLike;
	}

	public void setFeelsLike(BigDecimal feelsLike) {
		this.feelsLike = feelsLike;
	}

	public DetailedInformation tempMin(BigDecimal tempMin) {
		this.tempMin = tempMin;
		return this;
	}

	/**
	 * Get tempMin
	 * 
	 * @return tempMin
	 */
	@Valid
	@Schema(name = "temp_min", example = "28", required = false)
	@JsonProperty("temp_min")
	public BigDecimal getTempMin() {
		return tempMin;
	}

	public void setTempMin(BigDecimal tempMin) {
		this.tempMin = tempMin;
	}

	public DetailedInformation tempMax(BigDecimal tempMax) {
		this.tempMax = tempMax;
		return this;
	}

	/**
	 * Get tempMax
	 * 
	 * @return tempMax
	 */
	@Valid
	@Schema(name = "temp_max", example = "28", required = false)
	@JsonProperty("temp_max")
	public BigDecimal getTempMax() {
		return tempMax;
	}

	public void setTempMax(BigDecimal tempMax) {
		this.tempMax = tempMax;
	}

	public DetailedInformation pressure(BigDecimal pressure) {
		this.pressure = pressure;
		return this;
	}

	/**
	 * Get pressure
	 * 
	 * @return pressure
	 */
	@Valid
	@Schema(name = "pressure", example = "1000", required = false)
	@JsonProperty("pressure")
	public BigDecimal getPressure() {
		return pressure;
	}

	public void setPressure(BigDecimal pressure) {
		this.pressure = pressure;
	}

	public DetailedInformation humidity(BigDecimal humidity) {
		this.humidity = humidity;
		return this;
	}

	/**
	 * Get humidity
	 * 
	 * @return humidity
	 */
	@Valid
	@Schema(name = "humidity", example = "19", required = false)
	@JsonProperty("humidity")
	public BigDecimal getHumidity() {
		return humidity;
	}

	public void setHumidity(BigDecimal humidity) {
		this.humidity = humidity;
	}

	public DetailedInformation seaLevel(BigDecimal seaLevel) {
		this.seaLevel = seaLevel;
		return this;
	}

	/**
	 * Get seaLevel
	 * 
	 * @return seaLevel
	 */
	@Valid
	@Schema(name = "sea_level", example = "1000", required = false)
	@JsonProperty("sea_level")
	public BigDecimal getSeaLevel() {
		return seaLevel;
	}

	public void setSeaLevel(BigDecimal seaLevel) {
		this.seaLevel = seaLevel;
	}

	public DetailedInformation grndLevel(BigDecimal grndLevel) {
		this.grndLevel = grndLevel;
		return this;
	}

	/**
	 * Get grndLevel
	 * 
	 * @return grndLevel
	 */
	@Valid
	@Schema(name = "grnd_level", example = "1004", required = false)
	@JsonProperty("grnd_level")
	public BigDecimal getGrndLevel() {
		return grndLevel;
	}

	public void setGrndLevel(BigDecimal grndLevel) {
		this.grndLevel = grndLevel;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		DetailedInformation detailedInformation = (DetailedInformation) o;
		return Objects.equals(this.temp, detailedInformation.temp)
				&& Objects.equals(this.feelsLike, detailedInformation.feelsLike)
				&& Objects.equals(this.tempMin, detailedInformation.tempMin)
				&& Objects.equals(this.tempMax, detailedInformation.tempMax)
				&& Objects.equals(this.pressure, detailedInformation.pressure)
				&& Objects.equals(this.humidity, detailedInformation.humidity)
				&& Objects.equals(this.seaLevel, detailedInformation.seaLevel)
				&& Objects.equals(this.grndLevel, detailedInformation.grndLevel);
	}

	@Override
	public int hashCode() {
		return Objects.hash(temp, feelsLike, tempMin, tempMax, pressure, humidity, seaLevel, grndLevel);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class DetailedInformation {\n");
		sb.append("    temp: ").append(toIndentedString(temp)).append("\n");
		sb.append("    feelsLike: ").append(toIndentedString(feelsLike)).append("\n");
		sb.append("    tempMin: ").append(toIndentedString(tempMin)).append("\n");
		sb.append("    tempMax: ").append(toIndentedString(tempMax)).append("\n");
		sb.append("    pressure: ").append(toIndentedString(pressure)).append("\n");
		sb.append("    humidity: ").append(toIndentedString(humidity)).append("\n");
		sb.append("    seaLevel: ").append(toIndentedString(seaLevel)).append("\n");
		sb.append("    grndLevel: ").append(toIndentedString(grndLevel)).append("\n");
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
