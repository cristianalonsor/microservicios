package com.seittiffe.weather.ui.model;

import java.util.HashMap;
import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Possible additional statuses
 */

@Schema(name = "status_additionalStatus_inner", description = "Possible additional statuses")
@JsonTypeName("status_additionalStatus_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-05T15:30:51.630808200-04:00[America/Santiago]")
public class StatusAdditionalStatusInner extends HashMap<String, Object> {

	private static final long serialVersionUID = 1L;

	private Integer statusCode;

	private String serverStatusCode;

	/**
	 * API status severity code
	 */
	public enum SeverityEnum {
		INFO("Info"),

		WARNING("Warning"),

		ERROR("Error");

		private String value;

		SeverityEnum(String value) {
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
		public static SeverityEnum fromValue(String value) {
			for (SeverityEnum b : SeverityEnum.values()) {
				if (b.value.equals(value)) {
					return b;
				}
			}
			throw new IllegalArgumentException("Unexpected value '" + value + "'");
		}
	}

	private SeverityEnum severity;

	private String statusDescription;

	/**
	 * Default constructor
	 * 
	 * @deprecated Use
	 *             {@link StatusAdditionalStatusInner#StatusAdditionalStatusInner(Integer, SeverityEnum)}
	 */
	@Deprecated
	public StatusAdditionalStatusInner() {
		super();
	}

	/**
	 * Constructor with only required parameters
	 */
	public StatusAdditionalStatusInner(Integer statusCode, SeverityEnum severity) {
		super();
		this.statusCode = statusCode;
		this.severity = severity;
	}

	public StatusAdditionalStatusInner statusCode(Integer statusCode) {
		this.statusCode = statusCode;
		return this;
	}

	/**
	 * Response status code
	 * 
	 * @return statusCode
	 */
	@NotNull
	@Schema(name = "statusCode", description = "Response status code", required = true)
	@JsonProperty("statusCode")
	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public StatusAdditionalStatusInner serverStatusCode(String serverStatusCode) {
		this.serverStatusCode = serverStatusCode;
		return this;
	}

	/**
	 * Server status code
	 * 
	 * @return serverStatusCode
	 */
	@Size(max = 100)
	@Schema(name = "serverStatusCode", description = "Server status code", required = true)
	@JsonProperty("serverStatusCode")
	public String getServerStatusCode() {
		return serverStatusCode;
	}

	public void setServerStatusCode(String serverStatusCode) {
		this.serverStatusCode = serverStatusCode;
	}

	public StatusAdditionalStatusInner severity(SeverityEnum severity) {
		this.severity = severity;
		return this;
	}

	/**
	 * API status severity code
	 * 
	 * @return severity
	 */
	@NotNull
	@Schema(name = "severity", description = "API status severity code", required = true)
	@JsonProperty("severity")
	public SeverityEnum getSeverity() {
		return severity;
	}

	public void setSeverity(SeverityEnum severity) {
		this.severity = severity;
	}

	public StatusAdditionalStatusInner statusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
		return this;
	}

	/**
	 * Status description. Explanatory text associated with a status
	 * 
	 * @return statusDescription
	 */

	@Schema(name = "statusDescription", description = "Status description. Explanatory text associated with a status", required = false)
	@JsonProperty("statusDescription")
	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		StatusAdditionalStatusInner statusAdditionalStatusInner = (StatusAdditionalStatusInner) o;
		return Objects.equals(this.statusCode, statusAdditionalStatusInner.statusCode)
				&& Objects.equals(this.serverStatusCode, statusAdditionalStatusInner.serverStatusCode)
				&& Objects.equals(this.severity, statusAdditionalStatusInner.severity)
				&& Objects.equals(this.statusDescription, statusAdditionalStatusInner.statusDescription)
				&& super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(statusCode, serverStatusCode, severity, statusDescription, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class StatusAdditionalStatusInner {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
		sb.append("    serverStatusCode: ").append(toIndentedString(serverStatusCode)).append("\n");
		sb.append("    severity: ").append(toIndentedString(severity)).append("\n");
		sb.append("    statusDescription: ").append(toIndentedString(statusDescription)).append("\n");
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
