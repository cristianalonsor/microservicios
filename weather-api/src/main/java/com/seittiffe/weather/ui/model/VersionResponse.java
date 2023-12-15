package com.seittiffe.weather.ui.model;

import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * VersionResponse
 */

@JsonTypeName("versionResponse")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-05T15:30:51.630808200-04:00[America/Santiago]")
@Service
public class VersionResponse {

	private String name;

	private String version;

	/**
	 * Default constructor
	 * 
	 * @deprecated Use {@link VersionResponse#VersionResponse(String, String)}
	 */
	@Deprecated
	public VersionResponse() {
		super();
	}

	/**
	 * Constructor with only required parameters
	 */
	public VersionResponse(String name, String version) {
		this.name = name;
		this.version = version;
	}

	public VersionResponse name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Get name
	 * 
	 * @return name
	 */
	@NotNull
	@Schema(name = "name", example = "Weather API", required = true)
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public VersionResponse version(String version) {
		this.version = version;
		return this;
	}

	/**
	 * Get version
	 * 
	 * @return version
	 */
	@NotNull
	@Schema(name = "version", example = "0.0.1", required = true)
	@JsonProperty("version")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		VersionResponse versionResponse = (VersionResponse) o;
		return Objects.equals(this.name, versionResponse.name) && Objects.equals(this.version, versionResponse.version);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, version);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class VersionResponse {\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    version: ").append(toIndentedString(version)).append("\n");
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
