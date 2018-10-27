package com.LearnApi.TestBase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.LearnApi.Utilities.ReadProperties;
import com.LearnApi.Utilities.ReplaceString;

import io.restassured.RestAssured;


public class InItSetUp {
	
	ReplaceString replaceString;
	static String requestString;
	
	
	@BeforeClass
	public void setUp() {
		replaceString = new ReplaceString();
		requestString = replaceString.replaceString(ReadProperties.getProperty("programme"));
	}
	
	@BeforeMethod
	public void inIt() {
		RestAssured.baseURI = ReadProperties.getProperty("appHost");
		RestAssured.port = Integer.valueOf(ReadProperties.getProperty("appPort"));
		RestAssured.basePath = ReadProperties.getProperty("studentAppPath");
	}

}
