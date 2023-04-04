package ru.tele2.tests.api.models.requestnew;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MyObjectRoot {


	private List<MyObjectItem> myObject;

	public void setMyObject(List<MyObjectItem> myObject){
		this.myObject = myObject;
	}

	public List<MyObjectItem> getMyObject(){
		return myObject;
	}
}