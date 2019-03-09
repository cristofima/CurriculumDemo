package com.coronado.cv.payload.request;

import javax.validation.constraints.*;

public class SignUpForm {

	@NotBlank
	@Size(min = 5, max = 25)
	private String username;

	@NotBlank
	@Size(min = 8,max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(min = 6, max = 25)
	private String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}