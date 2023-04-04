package ru.tele2.tests.api.models.requestnew;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item{

	@JsonProperty("catalogId")
	private CatalogId catalogId;

	@JsonProperty("quantity")
	private int quantity;

	@JsonProperty("type")
	private String type;

	public void setCatalogId(CatalogId catalogId){
		this.catalogId = catalogId;
	}

	public CatalogId getCatalogId(){
		return catalogId;
	}

	public void setQuantity(int quantity){
		this.quantity = quantity;
	}

	public int getQuantity(){
		return quantity;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}
}