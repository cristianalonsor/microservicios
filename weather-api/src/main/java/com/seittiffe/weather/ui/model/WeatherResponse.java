package com.seittiffe.weather.ui.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Response object returned by weather api
 */

@Schema(name = "weatherResponse", description = "Response object returned by weather api")
@JsonTypeName("weatherResponse")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-05T15:30:51.630808200-04:00[America/Santiago]")
public class WeatherResponse {

	private Coordinates coord;

	@Valid
	private List<@Valid WeatherInner> weather;

	private String base;

	private DetailedInformation main;

	private BigDecimal visibility;

	private Wind wind;

	private Clouds clouds;

	private BigDecimal dt;

	private System sys;

	private BigDecimal timezone;

	private BigDecimal id;

	private String name;

	private BigDecimal cod;

	public WeatherResponse coord(Coordinates coord) {
		this.coord = coord;
		return this;
	}

	/**
	 * Get coord
	 * 
	 * @return coord
	 */
	@Valid
	@Schema(name = "coord", required = false)
	@JsonProperty("coord")
	public Coordinates getCoord() {
		return coord;
	}

	public void setCoord(Coordinates coord) {
		this.coord = coord;
	}

	public WeatherResponse weather(List<@Valid WeatherInner> weather) {
		this.weather = weather;
		return this;
	}

	public WeatherResponse addWeatherItem(WeatherInner weatherItem) {
		if (this.weather == null) {
			this.weather = new ArrayList<>();
		}
		this.weather.add(weatherItem);
		return this;
	}

	/**
	 * Weather information
	 * 
	 * @return weather
	 */
	@Valid
	@Schema(name = "weather", description = "Weather information", required = false)
	@JsonProperty("weather")
	public List<@Valid WeatherInner> getWeather() {
		return weather;
	}

	public void setWeather(List<@Valid WeatherInner> weather) {
		this.weather = weather;
	}

	public WeatherResponse base(String base) {
		this.base = base;
		return this;
	}

	/**
	 * Get base
	 * 
	 * @return base
	 */

	@Schema(name = "base", example = "stations", required = false)
	@JsonProperty("base")
	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public WeatherResponse main(DetailedInformation main) {
		this.main = main;
		return this;
	}

	/**
	 * Get main
	 * 
	 * @return main
	 */
	@Valid
	@Schema(name = "main", required = false)
	@JsonProperty("main")
	public DetailedInformation getMain() {
		return main;
	}

	public void setMain(DetailedInformation main) {
		this.main = main;
	}

	public WeatherResponse visibility(BigDecimal visibility) {
		this.visibility = visibility;
		return this;
	}

	/**
	 * Get visibility
	 * 
	 * @return visibility
	 */
	@Valid
	@Schema(name = "visibility", example = "10000", required = false)
	@JsonProperty("visibility")
	public BigDecimal getVisibility() {
		return visibility;
	}

	public void setVisibility(BigDecimal visibility) {
		this.visibility = visibility;
	}

	public WeatherResponse wind(Wind wind) {
		this.wind = wind;
		return this;
	}

	/**
	 * Get wind
	 * 
	 * @return wind
	 */
	@Valid
	@Schema(name = "wind", required = false)
	@JsonProperty("wind")
	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public WeatherResponse clouds(Clouds clouds) {
		this.clouds = clouds;
		return this;
	}

	/**
	 * Get clouds
	 * 
	 * @return clouds
	 */
	@Valid
	@Schema(name = "clouds", required = false)
	@JsonProperty("clouds")
	public Clouds getClouds() {
		return clouds;
	}

	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}

	public WeatherResponse dt(BigDecimal dt) {
		this.dt = dt;
		return this;
	}

	/**
	 * Get dt
	 * 
	 * @return dt
	 */
	@Valid
	@Schema(name = "dt", example = "1680714106", required = false)
	@JsonProperty("dt")
	public BigDecimal getDt() {
		return dt;
	}

	public void setDt(BigDecimal dt) {
		this.dt = dt;
	}

	public WeatherResponse sys(System sys) {
		this.sys = sys;
		return this;
	}

	/**
	 * Get sys
	 * 
	 * @return sys
	 */
	@Valid
	@Schema(name = "sys", required = false)
	@JsonProperty("sys")
	public System getSys() {
		return sys;
	}

	public void setSys(System sys) {
		this.sys = sys;
	}

	public WeatherResponse timezone(BigDecimal timezone) {
		this.timezone = timezone;
		return this;
	}

	/**
	 * Get timezone
	 * 
	 * @return timezone
	 */
	@Valid
	@Schema(name = "timezone", example = "10000", required = false)
	@JsonProperty("timezone")
	public BigDecimal getTimezone() {
		return timezone;
	}

	public void setTimezone(BigDecimal timezone) {
		this.timezone = timezone;
	}

	public WeatherResponse id(BigDecimal id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 */
	@Valid
	@Schema(name = "id", example = "98182", required = false)
	@JsonProperty("id")
	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public WeatherResponse name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Get name
	 * 
	 * @return name
	 */

	@Schema(name = "name", example = "Baghdad", required = false)
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WeatherResponse cod(BigDecimal cod) {
		this.cod = cod;
		return this;
	}

	/**
	 * Get cod
	 * 
	 * @return cod
	 */
	@Valid
	@Schema(name = "cod", example = "200", required = false)
	@JsonProperty("cod")
	public BigDecimal getCod() {
		return cod;
	}

	public void setCod(BigDecimal cod) {
		this.cod = cod;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		WeatherResponse weatherResponse = (WeatherResponse) o;
		return Objects.equals(this.coord, weatherResponse.coord)
				&& Objects.equals(this.weather, weatherResponse.weather)
				&& Objects.equals(this.base, weatherResponse.base) && Objects.equals(this.main, weatherResponse.main)
				&& Objects.equals(this.visibility, weatherResponse.visibility)
				&& Objects.equals(this.wind, weatherResponse.wind)
				&& Objects.equals(this.clouds, weatherResponse.clouds) && Objects.equals(this.dt, weatherResponse.dt)
				&& Objects.equals(this.sys, weatherResponse.sys)
				&& Objects.equals(this.timezone, weatherResponse.timezone)
				&& Objects.equals(this.id, weatherResponse.id) && Objects.equals(this.name, weatherResponse.name)
				&& Objects.equals(this.cod, weatherResponse.cod);
	}

	@Override
	public int hashCode() {
		return Objects.hash(coord, weather, base, main, visibility, wind, clouds, dt, sys, timezone, id, name, cod);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class WeatherResponse {\n");
		sb.append("    coord: ").append(toIndentedString(coord)).append("\n");
		sb.append("    weather: ").append(toIndentedString(weather)).append("\n");
		sb.append("    base: ").append(toIndentedString(base)).append("\n");
		sb.append("    main: ").append(toIndentedString(main)).append("\n");
		sb.append("    visibility: ").append(toIndentedString(visibility)).append("\n");
		sb.append("    wind: ").append(toIndentedString(wind)).append("\n");
		sb.append("    clouds: ").append(toIndentedString(clouds)).append("\n");
		sb.append("    dt: ").append(toIndentedString(dt)).append("\n");
		sb.append("    sys: ").append(toIndentedString(sys)).append("\n");
		sb.append("    timezone: ").append(toIndentedString(timezone)).append("\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    cod: ").append(toIndentedString(cod)).append("\n");
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
