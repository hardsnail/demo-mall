package com.demo.user.server.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.user.server.entity.User;
import com.demo.user.server.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {

	@Resource
	private UserService userService;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public User home(ModelAndView mav){
		mav.addObject("message", "ok");
		User user = new User();
		user.setId(1L);
		user.setName("james");
//		userService.insert(user);
		return user;
	}
}
