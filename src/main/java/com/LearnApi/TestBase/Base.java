package com.LearnApi.TestBase;

import static io.restassured.RestAssured.*;

import com.LearnApi.POJO.StudentPojo;
import com.google.gson.Gson;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Base extends InItSetUp{
	
	Gson gson;
	StudentPojo studentPojo;
	
	public void getJsonObject(String jsonString){
		
		gson = new Gson();
		studentPojo = gson.fromJson(jsonString,StudentPojo.class);
		System.out.println(studentPojo.getId());
	}
	
	public Response getGivenAs(String path) {
		return given().when().get(path);
	}
	
	public Response getGivenAs(RequestSpecification requestSpecs, String path){
		return given().spec(requestSpecs).when().get(path);
	}
	
	public Response getGivenAs(){
		return given().when().get();
	}


}
