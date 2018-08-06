package com.farukgenc.exception;

public class UserNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	private String userCode;
	private String description;

	public UserNotFoundException(String userCode, String desc) {
		this.userCode = userCode;
		this.description = desc;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
