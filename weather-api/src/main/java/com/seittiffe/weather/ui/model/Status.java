package com.seittiffe.weather.ui.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * API status. Define the errir reporting structure that may be returned by an
 * API call
 */

@Schema(name = "status", description = "API status. Define the errir reporting structure that may be returned by an API call")
@JsonTypeName("status")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-05T15:30:51.630808200-04:00[America/Santiago]")
public class Status extends HashMap<String, Object> {

	private static final long serialVersionUID = -2555357928379651085L;

	private String serverStatusCode;

	/**
	 * API status severity code. Valid values: Error & Warning. Use these to tag the
	 * issue accordingly
	 */
	public enum SeverityEnum {
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

	@Valid
	private List<StatusAdditionalStatusInner> additionalStatus;

	/**
	 * Default constructor
	 * 
	 * @deprecated Use {@link Status#Status(String, SeverityEnum)}
	 */
	@Deprecated
	public Status() {
		super();
	}

	/**
	 * Constructor with only required parameters
	 */
	public Status(String serverStatusCode, SeverityEnum severity) {
		super();
		this.serverStatusCode = serverStatusCode;
		this.severity = severity;
	}

	public Status serverStatusCode(String serverStatusCode) {
		this.serverStatusCode = serverStatusCode;
		return this;
	}

	/**
	 * HTTP server status code. The value placed here os used to allow client to
	 * display a status code to the user.
	 * 
	 * @return serverStatusCode
	 */
	@NotNull
	@JsonProperty("serverStatusCode")
	public String getServerStatusCode() {
		return serverStatusCode;
	}

	public void setServerStatusCode(String serverStatusCode) {
		this.serverStatusCode = serverStatusCode;
	}

	public Status severity(SeverityEnum severity) {
		this.severity = severity;
		return this;
	}

	/**
	 * API status severity code. Valid values: Error & Warning. Use these to tag the
	 * issue accordingly
	 * 
	 * @return severity
	 */
	@NotNull
	@Schema(name = "severity", description = "API status severity code. Valid values: Error & Warning. Use these to tag the issue accordingly", required = true)
	@JsonProperty("severity")
	public SeverityEnum getSeverity() {
		return severity;
	}

	public void setSeverity(SeverityEnum severity) {
		this.severity = severity;
	}

	public Status additionalStatus(List<StatusAdditionalStatusInner> additionalStatus) {
		this.additionalStatus = additionalStatus;
		return this;
	}

	public Status addAdditionalStatusItem(StatusAdditionalStatusInner additionalStatusItem) {
		if (this.additionalStatus == null) {
			this.additionalStatus = new ArrayList<>();
		}
		this.additionalStatus.add(additionalStatusItem);
		return this;
	}

	/**
	 * API Additional statuses. This aggregate may appear for each additional status
	 * that the server intends to provide
	 * 
	 * @return additionalStatus
	 */
	@Valid
	@Schema(name = "additionalStatus", description = "API Additional statuses. This aggregate may appear for each additional status that the server intends to provide", required = false)
	@JsonProperty("additionalStatus")
	public List<StatusAdditionalStatusInner> getAdditionalStatus() {
		return additionalStatus;
	}

	public void setAdditionalStatus(List<StatusAdditionalStatusInner> additionalStatus) {
		this.additionalStatus = additionalStatus;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Status status = (Status) o;
		return Objects.equals(this.serverStatusCode, status.serverStatusCode)
				&& Objects.equals(this.severity, status.severity)
				&& Objects.equals(this.additionalStatus, status.additionalStatus) && super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(serverStatusCode, severity, additionalStatus, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Status {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    serverStatusCode: ").append(toIndentedString(serverStatusCode)).append("\n");
		sb.append("    severity: ").append(toIndentedString(severity)).append("\n");
		sb.append("    additionalStatus: ").append(toIndentedString(additionalStatus)).append("\n");
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
