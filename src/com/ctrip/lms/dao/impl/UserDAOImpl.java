package com.ctrip.lms.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.ctrip.lms.dao.UserDAO;
import com.ctrip.lms.models.User;

public class UserDAOImpl implements UserDAO {
	private final static List<User> USER_LIST = new ArrayList<User>();
	
	public boolean addUser(User user) {
		if (USER_LIST.contains(user)) {
			System.out.println("User details already exists.");
		}
		return USER_LIST.add(user);
	}

}
