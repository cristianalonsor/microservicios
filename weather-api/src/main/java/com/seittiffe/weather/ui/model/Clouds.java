package com.seittiffe.weather.ui.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Cloud information
 */

@Schema(name = "Clouds", description = "Cloud information")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-05T15:30:51.630808200-04:00[America/Santiago]")
public class Clouds {

	private BigDecimal all;

	public Clouds all(BigDecimal all) {
		this.all = all;
		return this;
	}

	/**
	 * Get all
	 * 
	 * @return all
	 */
	@Valid
	@Schema(name = "all", example = "27", required = true)
	@JsonProperty("all")
	public BigDecimal getAll() {
		return all;
	}

	public void setAll(BigDecimal all) {
		this.all = all;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Clouds clouds = (Clouds) o;
		return Objects.equals(this.all, clouds.all);
	}

	@Override
	public int hashCode() {
		return Objects.hash(all);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Clouds {\n");
		sb.append("    all: ").append(toIndentedString(all)).append("\n");
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
