package com.sparkies.spark.payload.request;

public class LoginRequest {

	private String username;
	
	private String userEmail;

	private String userPwd;

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public LoginRequest() {
		super();
	}

	public LoginRequest(String userEmail, String userPwd) {
		super();
		this.userEmail = username;
		this.userPwd = userPwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getuserPwd() {
		return userPwd;
	}

	public void setuserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

}
