package com.demo.user.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import com.demo.user.web.controller.UserController;

@EnableAutoConfiguration
@Configuration
public class App {
	public static void main(String[] args) {
		Object[] classes = new Object[]{App.class, UserController.class};
		SpringApplication.run(classes, args);
	}
}
