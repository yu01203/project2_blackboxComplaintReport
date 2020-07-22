package com.ssafy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.domain.User;
import com.ssafy.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService service;
	
	@GetMapping("login")
	public String login(String email, String password, HttpSession session, Model model) {
		System.out.println("로그인 시도");
		String result = "";
		
		User input = new User();
		input.setEmail(email);
		input.setPassword(password);

		try {
			User user = service.login(input);
			
			if(user != null) {
				session.setAttribute("userinfo", user);
				result = "success";
			} else result = "null";
		} catch (Exception e) {
			e.printStackTrace();
			result = "error";
		}
		System.out.println(result);
		return result;
	}
}
