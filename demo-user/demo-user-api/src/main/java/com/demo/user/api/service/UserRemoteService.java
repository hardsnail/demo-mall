package com.demo.user.api.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.user.api.entity.UserDTO;

@FeignClient(value="demo-user-server")
public interface UserRemoteService {

	@RequestMapping(value="/users/addTowUser", method=RequestMethod.POST)
	public Long addTowUser(UserDTO userDTO);
	
}
