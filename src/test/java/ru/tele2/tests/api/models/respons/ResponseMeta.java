package ru.tele2.tests.api.models.respons;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseMeta{

	@JsonProperty("meta")
	private Meta meta;

	public Meta getMeta(){
		return meta;
	}
}