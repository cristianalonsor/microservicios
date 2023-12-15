package com.seittiffe.weather.ui.model;

import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * APIProvider
 */

@JsonTypeName("API_Provider")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-05T15:30:51.630808200-04:00[America/Santiago]")
@Service
public class APIProvider {

	private String name;

	private APIHealthStatus health;

	/**
	 * Default constructor
	 * 
	 * @deprecated Use {@link APIProvider#APIProvider(String, APIHealthStatus)}
	 */
	@Deprecated
	public APIProvider() {
		super();
	}

	/**
	 * Constructor with only required parameters
	 */
	public APIProvider(String name, APIHealthStatus health) {
		this.name = name;
		this.health = health;
	}

	public APIProvider name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Get name
	 * 
	 * @return name
	 */
	@NotNull
	@Schema(name = "name", example = "Main Provider", required = true)
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public APIProvider health(APIHealthStatus health) {
		this.health = health;
		return this;
	}

	/**
	 * Get health
	 * 
	 * @return health
	 */
	@NotNull
	@Valid
	@Schema(name = "health", required = true)
	@JsonProperty("health")
	public APIHealthStatus getHealth() {
		return health;
	}

	public void setHealth(APIHealthStatus health) {
		this.health = health;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		APIProvider apIProvider = (APIProvider) o;
		return Objects.equals(this.name, apIProvider.name) && Objects.equals(this.health, apIProvider.health);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, health);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class APIProvider {\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    health: ").append(toIndentedString(health)).append("\n");
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
