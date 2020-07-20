package com.ssafy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.domain.User;
import com.ssafy.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService service;
	
	@RequestMapping("login")
	public String login(User input, HttpSession session, Model model) {
		String result = "";
		
		try {
			User user = service.login(input);
			if(user != null) {
				session.setAttribute("userinfo", user);
				result = "success";
			} else {
				result = "null";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "error";
		}
		
		return result;
	}
}
