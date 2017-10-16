package com.demo.user.web.controller;

import java.util.Date;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.user.api.entity.UserDTO;

@Controller
@RequestMapping("api/user")
public class UserController {
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	String home() {
        return "User Model";
    }


	@ResponseBody
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public UserDTO get(@PathParam("id") Long id){
		UserDTO user = new UserDTO();
		user.setName("Rebecca");
		user.setRegisterDate(new Date());
		return user;
	}
}
