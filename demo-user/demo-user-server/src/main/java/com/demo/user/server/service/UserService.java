package com.demo.user.server.service;

import org.springframework.transaction.annotation.Transactional;

import com.demo.user.server.entity.User;

public interface UserService {

	@Transactional
	public int insert(User user);
	
	
	@Transactional
	public int insertTwoUser(User user);
}
