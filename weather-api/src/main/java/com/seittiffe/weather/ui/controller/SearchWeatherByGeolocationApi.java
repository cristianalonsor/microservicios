/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.5.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.seittiffe.weather.ui.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Optional;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

import com.seittiffe.weather.ui.model.Status;
import com.seittiffe.weather.ui.model.WeatherResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-05T15:30:51.630808200-04:00[America/Santiago]")
@Validated
@Tag(name = "searchWeatherByGeolocation", description = "the searchWeatherByGeolocation API")
public interface SearchWeatherByGeolocationApi {

	default Optional<NativeWebRequest> getRequest() {
		return Optional.empty();
	}

	/**
	 * GET /searchWeatherByGeolocation Search weather information using country.city
	 * name and limit of results
	 *
	 * @param city  City name to search weather information, may contain country
	 *              code to narrow down results using the pattern
	 *              &lt;CityName&gt;,&lt;CountryCode&gt; -&gt; Santiago,cl
	 *              (required)
	 * @param limit Limit the possible results (required)
	 * @Param unit Unit of measurement: -> Imperial/Metric
	 * @return 200 - Success (status code 200) or 400 - Bad Request (status code
	 *         400) or 500 - Internal Server Error (status code 500)
	 */
	@Operation(operationId = "searchByGeolocation", description = "Search weather information using country.city name and limit of results", responses = {
			@ApiResponse(responseCode = "200", description = "200 - Success", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = WeatherResponse.class)) }),
			@ApiResponse(responseCode = "400", description = "400 - Bad Request", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Status.class)) }),
			@ApiResponse(responseCode = "500", description = "500 - Internal Server Error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Status.class)) }) })
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping(value = "/searchWeatherByGeolocation", produces = { "application/json" })
	ResponseEntity<WeatherResponse> searchByGeolocation(
			@NotNull @Parameter(name = "city", description = "City name to search weather information, may contain country code to narrow down results using the pattern <CityName>,<CountryCode> -> Santiago,cl", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "city", required = true) String city,
			@NotNull @Parameter(name = "limit", description = "Limit the possible results", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "limit", required = true) BigDecimal limit,
			@NotNull @Parameter(name = "unit", description = "Unit of measurement", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "unit", required = true) String unit) throws UnsupportedEncodingException;

}