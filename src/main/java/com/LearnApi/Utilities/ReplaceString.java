package com.LearnApi.Utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;

import com.LearnApi.MongoDb.ConnectMongoDB;
import com.mongodb.MongoTimeoutException;

public class ReplaceString {

	ConnectMongoDB connectMDB;
	String requestString;

	public String replacingMongoIds() {
		try {
			connectMDB = new ConnectMongoDB();
			requestString = connectMDB.getCollection(ReadProperties.getProperty("collectionName"));
			return requestString.replace(requestString.substring(1, requestString.indexOf("}, ")), "").replace("}, ",
					"");

		} catch (MongoTimeoutException mongoTimeoutException) {
			Assert.fail("Mongo DB connection failed" + mongoTimeoutException.getMessage());
		}

		return null;

	}

	private String generateRandomString(int count) {
		return RandomStringUtils.randomAlphabetic(count);
	}

	private String replaceRandomText(String string) {
		return string.replace("{{randomText}}", generateRandomString(9));
	}

	private Map<String, ? super Object> replaceProgram() {

		Map<String, ? super Object> programCourse = new HashMap<>();

		programCourse.put("Accounting", "Financial Analysis");
		programCourse.put("Statistics", "Financial Analysis");
		programCourse.put("Calculus", "Computer Science");
		programCourse.put("Algorithms", "Computer Science");
		programCourse.put("Machine Element Design", "Mechanical Engineering");
		programCourse.put("Engineering Analysis I", "Mechanical Engineering");
		programCourse.put("Criminal Law", "Law");
		programCourse.put("Constitutional Law", "Law");
		programCourse.put("Property Law", "Law");
		programCourse.put("Contracts", "Law");
		programCourse.put("Anatomy", "Medicine");
		programCourse.put("Biochemistry", "Medicine");
		programCourse.put("Genetics", "Medicine");
		programCourse.put("Human Behavior.", "Medicine");

		return programCourse;

	}

	public String replaceString(String program) {

		Map<String, ? super Object> programC = new HashMap<>();
		List<String> keys = new ArrayList<>();
		
		programC = replaceProgram();

		for (Map.Entry<String, ? super Object> entry : programC.entrySet()) {
			if (entry.getValue().toString().contains(program)) {
				keys.add(entry.getKey());
			}
		}

		requestString = replacingMongoIds();
		
		requestString = replaceRandomText(requestString);
		return requestString.replace("{{program}}", program).replace("{{course1}}", keys.get(0))
				.replace("{{course2}}", keys.get(1));

	}

}
