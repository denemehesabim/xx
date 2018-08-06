package com.farukgenc.web.resources;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResource implements Serializable {

	private static final long serialVersionUID = 895346879572613811L;

	public ErrorResource(String desc, String error) {
		super();
		this.desc = desc;
		this.error = error;
	}

	@JsonProperty(value = "error_description")
	private String desc;

	@JsonProperty(value = "error")
	private String error;

	public String getDesc() {
		return desc;
	}

	public String getError() {
		return error;
	}

}
