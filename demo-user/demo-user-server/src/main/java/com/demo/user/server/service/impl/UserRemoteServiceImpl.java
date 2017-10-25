package com.demo.user.server.service.impl;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.user.api.entity.UserDTO;
import com.demo.user.api.service.UserRemoteService;
import com.demo.user.server.entity.User;
import com.demo.user.server.service.UserService;

@RestController
@RequestMapping("users")
public class UserRemoteServiceImpl implements UserRemoteService{

	@Resource
	private UserService userService;
	
	@Override
	@RequestMapping(value="addTowUser",method=RequestMethod.POST)
	public Long addTowUser(@RequestBody UserDTO userDTO) {
		User user = new User();
		user.setId(userDTO.getId());
		user.setName(userDTO.getName());
		int result = userService.insertTwoUser(user);
		return Long.valueOf(result);
	}

	
}
