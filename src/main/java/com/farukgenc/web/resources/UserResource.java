package com.farukgenc.web.resources;

import org.springframework.hateoas.ResourceSupport;

public class UserResource extends ResourceSupport {

	private Long objId;

	private String userName;

	private String lastName;

	public Long getObjId() {
		return objId;
	}

	public void setObjId(Long objId) {
		this.objId = objId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
