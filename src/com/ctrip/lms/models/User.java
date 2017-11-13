package com.ctrip.lms.models;

public class User {
	private long userId;
	private String name;

	public User(String name) {
		super();
		this.name = name;
	}
	
	public User(long userId, String name) {
		super();
		this.userId = userId;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public long getUserId() {
		return userId;
	}
	
}
