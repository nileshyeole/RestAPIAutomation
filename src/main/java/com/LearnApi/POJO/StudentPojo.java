package com.LearnApi.POJO;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StudentPojo {

	@SerializedName("id")
	@Expose
	private Integer id;
	@SerializedName("firstName")
	@Expose
	private String firstName;
	@SerializedName("lastName")
	@Expose
	private String lastName;
	@SerializedName("email")
	@Expose
	private String email;
	@SerializedName("programme")
	@Expose
	private String programme;
	@SerializedName("courses")
	@Expose
	private List<String> courses = null;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProgramme() {
		return programme;
	}

	public void setProgramme(String programme) {
		this.programme = programme;
	}

	public List<String> getCourses() {
		return courses;
	}

	public void setCourses(List<String> courses) {
		this.courses = courses;
	}

}
