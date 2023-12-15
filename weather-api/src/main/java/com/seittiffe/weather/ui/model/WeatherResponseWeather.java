package com.seittiffe.weather.ui.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * WeatherResponseWeather
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-05T14:07:19.045954600-04:00[America/Santiago]")
public class WeatherResponseWeather {
	@JsonProperty("id")
	private Integer id;

	@JsonProperty("main")
	private String main;

	@JsonProperty("description")
	private String description;

	@JsonProperty("icon")
	private String icon;

	public WeatherResponseWeather id(Integer id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public WeatherResponseWeather main(String main) {
		this.main = main;
		return this;
	}

	/**
	 * Get main
	 * 
	 * @return main
	 */
	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public WeatherResponseWeather description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Get description
	 * 
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public WeatherResponseWeather icon(String icon) {
		this.icon = icon;
		return this;
	}

	/**
	 * Get icon
	 * 
	 * @return icon
	 */
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
		WeatherResponseWeather weatherResponseWeather = (WeatherResponseWeather) o;
		return Objects.equals(this.id, weatherResponseWeather.id)
				&& Objects.equals(this.main, weatherResponseWeather.main)
				&& Objects.equals(this.description, weatherResponseWeather.description)
				&& Objects.equals(this.icon, weatherResponseWeather.icon);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, main, description, icon);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class WeatherResponseWeather {\n");

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
