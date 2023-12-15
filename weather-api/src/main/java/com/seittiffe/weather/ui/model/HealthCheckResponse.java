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
 * HealthCheckResponse
 */

@JsonTypeName("healthCheckResponse")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-05T15:30:51.630808200-04:00[America/Santiago]")
@Service
public class HealthCheckResponse {

	private String name;

	private String version;

	private APIProvider provider;

	/**
	 * Default constructor
	 * 
	 * @deprecated Use
	 *             {@link HealthCheckResponse#HealthCheckResponse(String, String, APIProvider)}
	 */
	@Deprecated
	public HealthCheckResponse() {
		super();
	}

	/**
	 * Constructor with only required parameters
	 */
	public HealthCheckResponse(String name, String version, APIProvider provider) {
		this.name = name;
		this.version = version;
		this.provider = provider;
	}

	public HealthCheckResponse name(String name) {
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

	public HealthCheckResponse version(String version) {
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

	public HealthCheckResponse provider(APIProvider provider) {
		this.provider = provider;
		return this;
	}

	/**
	 * Get provider
	 * 
	 * @return provider
	 */
	@NotNull
	@Valid
	@Schema(name = "provider", required = true)
	@JsonProperty("provider")
	public APIProvider getProvider() {
		return provider;
	}

	public void setProvider(APIProvider provider) {
		this.provider = provider;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		HealthCheckResponse healthCheckResponse = (HealthCheckResponse) o;
		return Objects.equals(this.name, healthCheckResponse.name)
				&& Objects.equals(this.version, healthCheckResponse.version)
				&& Objects.equals(this.provider, healthCheckResponse.provider);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, version, provider);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class HealthCheckResponse {\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    version: ").append(toIndentedString(version)).append("\n");
		sb.append("    provider: ").append(toIndentedString(provider)).append("\n");
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
