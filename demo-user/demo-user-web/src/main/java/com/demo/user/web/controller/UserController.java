package com.demo.user.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api/user")
public class UserController {
	
	@ResponseBody
	@RequestMapping("")
	String home() {
        return "Hello World!";
    }

}
