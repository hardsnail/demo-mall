package com.demo.user.server.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.demo.user.server.entity.User;
import com.demo.user.server.mapper.UserDao;
import com.demo.user.server.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	
	@Override
	public int insert(User user) {
		return userDao.insert(user);
	}

}
