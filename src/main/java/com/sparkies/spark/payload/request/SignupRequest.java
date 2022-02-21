package com.sparkies.spark.payload.request;

import com.sparkies.spark.model.User;

public class SignupRequest extends User {

	// private Set<String> role;

	public SignupRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SignupRequest(String username, String userEmail, String userPwd) {
		super(username, userEmail, userPwd);

	}

//	public Set<String> getRole() {
//		return this.role;
//	}
//
//	public void setRole(Set<String> role) {
//		this.role = role;
//	}
//
//	public SignupRequest(Set<String> role) {
//		super();
//		this.role = role;
//	}

}
