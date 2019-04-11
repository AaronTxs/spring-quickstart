package com.spring.xiecf.sample02.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.xiecf.sample02.models.User;

@RestController
public class HelloController {

	@RequestMapping("/getUser")
	public User getUser() {
		User user=new User();
    	user.setUserName("小明");
    	user.setPassWord("xxxxaaa");
        return user;
	}
}
