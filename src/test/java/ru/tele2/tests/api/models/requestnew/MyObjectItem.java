package ru.tele2.tests.api.models.requestnew;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MyObjectItem  {

	@JsonProperty("item")
	private Item item;

	public void setItem(Item item){
		this.item = item;
	}

	public Item getItem(){
		return item;
	}
}