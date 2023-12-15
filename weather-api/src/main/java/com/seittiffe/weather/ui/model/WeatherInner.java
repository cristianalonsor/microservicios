package com.seittiffe.weather.ui.model;

import java.util.Objects;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * WeatherInner
 */

@JsonTypeName("Weather_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-05T15:30:51.630808200-04:00[America/Santiago]")
public class WeatherInner {

	private Integer id;

	private String main;

	private String description;

	private String icon;

	public WeatherInner id(Integer id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 */

	@Schema(name = "id", example = "802", required = false)
	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public WeatherInner main(String main) {
		this.main = main;
		return this;
	}

	/**
	 * Get main
	 * 
	 * @return main
	 */

	@Schema(name = "main", example = "Clouds", required = false)
	@JsonProperty("main")
	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public WeatherInner description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Get description
	 * 
	 * @return description
	 */

	@Schema(name = "description", example = "Scattered clouds", required = false)
	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public WeatherInner icon(String icon) {
		this.icon = icon;
		return this;
	}

	/**
	 * Get icon
	 * 
	 * @return icon
	 */

	@Schema(name = "icon", example = "03n", required = false)
	@JsonProperty("icon")
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		WeatherInner weatherInner = (WeatherInner) o;
		return Objects.equals(this.id, weatherInner.id) && Objects.equals(this.main, weatherInner.main)
				&& Objects.equals(this.description, weatherInner.description)
				&& Objects.equals(this.icon, weatherInner.icon);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, main, description, icon);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class WeatherInner {\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    main: ").append(toIndentedString(main)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    icon: ").append(toIndentedString(icon)).append("\n");
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
