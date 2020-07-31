package com.ssafy.domain;

import java.util.Date;

public class SNSUser {
	private String id;
	private String email;
	private String name;
	private String gender;
	private Date birth;

	public SNSUser() {}
	public SNSUser(String id, String email, String name, String gender, Date birth) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.gender = gender;
		this.birth = birth;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "SNSUser [id=" + id + ", email=" + email + ", name=" + name + ", gender=" + gender + ", birth=" + birth
				+ "]";
	}
}
