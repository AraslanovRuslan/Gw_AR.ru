package ru.tele2.tests.api.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CatalogId{

	@JsonProperty("productId")
	private String productId;

	@JsonProperty("skuId")
	private String skuId;

	public void setProductId(String productId){
		this.productId = productId;
	}

	public String getProductId(){
		return productId;
	}

	public void setSkuId(String skuId){
		this.skuId = skuId;
	}

	public String getSkuId(){
		return skuId;
	}
}