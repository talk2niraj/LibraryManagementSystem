package com.ctrip.lms.models;

public class Author {
	private long autherId;
	private String autherName;
	//Omitting other details
	public Author(long autherId, String autherName) {
		super();
		this.autherId = autherId;
		this.autherName = autherName;
	}
	public long getAutherId() {
		return autherId;
	}
	public String getAutherName() {
		return autherName;
	}
}
