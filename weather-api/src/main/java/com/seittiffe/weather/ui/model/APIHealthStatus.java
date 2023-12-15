package com.seittiffe.weather.ui.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * APIHealthStatus
 */

@JsonTypeName("API_Health_Status")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-05T15:30:51.630808200-04:00[America/Santiago]")
@Service
public class APIHealthStatus {

	@Valid
	private List<@Valid Dependency> dependencies = new ArrayList<>();

	/**
	 * Default constructor
	 * 
	 * @deprecated Use {@link APIHealthStatus#APIHealthStatus(List<@Valid
	 *             Dependency>)}
	 */
	@Deprecated
	public APIHealthStatus() {
		super();
	}

	/**
	 * Constructor with only required parameters
	 */
	public APIHealthStatus(List<@Valid Dependency> dependencies) {
		this.dependencies = dependencies;
	}

	public APIHealthStatus dependencies(List<@Valid Dependency> dependencies) {
		this.dependencies = dependencies;
		return this;
	}

	public APIHealthStatus addDependenciesItem(Dependency dependenciesItem) {
		if (this.dependencies == null) {
			this.dependencies = new ArrayList<>();
		}
		this.dependencies.add(dependenciesItem);
		return this;
	}

	/**
	 * Get dependencies
	 * 
	 * @return dependencies
	 */
	@NotNull
	@Valid
	@Schema(name = "dependencies", required = true)
	@JsonProperty("dependencies")
	public List<@Valid Dependency> getDependencies() {
		return dependencies;
	}

	public void setDependencies(List<@Valid Dependency> dependencies) {
		this.dependencies = dependencies;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		APIHealthStatus apIHealthStatus = (APIHealthStatus) o;
		return Objects.equals(this.dependencies, apIHealthStatus.dependencies);
	}

	@Override
	public int hashCode() {
		return Objects.hash(dependencies);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class APIHealthStatus {\n");
		sb.append("    dependencies: ").append(toIndentedString(dependencies)).append("\n");
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
