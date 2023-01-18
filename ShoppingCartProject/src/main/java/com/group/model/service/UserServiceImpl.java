package com.group.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.entity.User;
import com.group.model.persistence.UserDao;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public User loginUser(User user) {
		return userDao.getUserByUserNameAndUserPassword(user.getUserName(), user.getUserPassword());
	}
	
	@Override
	public User addUser(User user) {
		return userDao.save(user);
	}

}
