package ru.tele2.tests.api.models.respons;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Meta{

	@JsonProperty("status")
	private String status;

	public String getStatus(){
		return status;
	}
}