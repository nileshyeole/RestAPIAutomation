package com.Learn.Tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.LearnApi.TestBase.Base;
import com.LearnApi.TestBase.IBasePathInterface;
import com.LearnApi.TestBase.ResponseVerification;
import com.LearnApi.Utilities.ReplaceString;

import io.restassured.response.Response;

public class getStudentTest extends Base {

	ReplaceString replaceString;
	Response response;
	int listSize;
	String firstName;
	List<String> firstNames;
	ResponseVerification verification;

	@Test
	public void test1_GetStudentList() {
		firstNames = new ArrayList<>();

		response = getGivenAs("/list");
		ResponseVerification.checkResponseStatus(response, IBasePathInterface.SUCCESS_STATUS_CODE);

		listSize = response.then().extract().jsonPath().getList("firstName").size();
		firstNames = response.then().extract().jsonPath().getList("firstName");

		firstName = firstNames.get(listSize - 1);

	}

	@Test
	public void tets2_GetSpecificStudent() {
		verification = new ResponseVerification();
		response = getGivenAs(String.valueOf(listSize));

		response.then().spec(verification.checkStatus(IBasePathInterface.SUCCESS_STATUS_CODE));

		response.then().spec(verification.valueEqualTo("firstName", firstName));
	}
	


}
