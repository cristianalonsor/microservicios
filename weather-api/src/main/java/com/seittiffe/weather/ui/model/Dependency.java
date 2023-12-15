package com.seittiffe.weather.ui.model;

import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Dependency
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-05T15:30:51.630808200-04:00[America/Santiago]")
@Service
public class Dependency {

	private String dependency;

	/**
	 * Gets or Sets status
	 */
	public enum StatusEnum {
		UP("UP"),

		DOWN("DOWN"),

		ERROR("ERROR");

		private String value;

		StatusEnum(String value) {
			this.value = value;
		}

		@JsonValue
		public String getValue() {
			return value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static StatusEnum fromValue(String value) {
			for (StatusEnum b : StatusEnum.values()) {
				if (b.value.equals(value)) {
					return b;
				}
			}
			throw new IllegalArgumentException("Unexpected value '" + value + "'");
		}
	}

	private StatusEnum status;

	/**
	 * Default constructor
	 * 
	 * @deprecated Use {@link Dependency#Dependency(String, StatusEnum)}
	 */
	@Deprecated
	public Dependency() {
		super();
	}

	/**
	 * Constructor with only required parameters
	 */
	public Dependency(String dependency, StatusEnum status) {
		this.dependency = dependency;
		this.status = status;
	}

	public Dependency dependency(String dependency) {
		this.dependency = dependency;
		return this;
	}

	/**
	 * Get dependency
	 * 
	 * @return dependency
	 */
	@NotNull
	@Schema(name = "dependency", example = "Weather API", required = true)
	@JsonProperty("dependency")
	public String getDependency() {
		return dependency;
	}

	public void setDependency(String dependency) {
		this.dependency = dependency;
	}

	public Dependency status(StatusEnum status) {
		this.status = status;
		return this;
	}

	/**
	 * Get status
	 * 
	 * @return status
	 */
	@NotNull
	@Schema(name = "status", example = "UP", required = true)
	@JsonProperty("status")
	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Dependency dependency = (Dependency) o;
		return Objects.equals(this.dependency, dependency.dependency) && Objects.equals(this.status, dependency.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(dependency, status);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Dependency {\n");
		sb.append("    dependency: ").append(toIndentedString(dependency)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
