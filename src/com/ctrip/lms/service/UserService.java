package com.ctrip.lms.service;

import com.ctrip.lms.dao.impl.UserDAOImpl;
import com.ctrip.lms.exception.LBSException;
import com.ctrip.lms.models.User;
import com.ctrip.lms.validator.Validator;

public class UserService {
	UserDAOImpl userDAO = new UserDAOImpl();

	public boolean addUser(User user) throws LBSException {
		if (Validator.catchInvalidUser(user)) {
			throw new LBSException("Invalid user information.");
		}
			
		return userDAO.addUser(user);
	}
}
