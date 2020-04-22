package com.myblog.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myblog.rest.model.User;
import com.myblog.rest.service.UserService;

@RestController
public class UserRegistrationController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "blog/register", method = RequestMethod.POST)
	public boolean addUser(@RequestBody User user) {
		if (userService.findByUsername(user)) {
			return false;
		}
		userService.register(user);
		return true;
	}
	
}
