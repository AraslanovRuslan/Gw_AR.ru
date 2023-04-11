package ru.tele2.tests.api.models.request;

import java.util.List;

public class MyObjectRoot {


	private List<MyObjectItem> myObject;

	public void setMyObject(List<MyObjectItem> myObject){
		this.myObject = myObject;
	}

	public List<MyObjectItem> getMyObject(){
		return myObject;
	}
}