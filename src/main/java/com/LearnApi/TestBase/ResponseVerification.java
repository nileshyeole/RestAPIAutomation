package com.LearnApi.TestBase;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.*;


public class ResponseVerification {
	
	static ResponseSpecBuilder builder;
	
	public ResponseVerification() {
		builder = new ResponseSpecBuilder();
	}
	
	public static void checkResponseStatus(Response response, int expectedStatusCode){
		response.then().statusCode(expectedStatusCode);
	}
	
	public ResponseSpecification checkStatus(int expectedStatusCode){
		return builder.expectStatusCode(expectedStatusCode).build();
	}
	
	public ResponseSpecification valueEqualTo(String path, String expectedValue){
		return builder.expectBody(path,equalTo(expectedValue.trim())).build();
	}

}
