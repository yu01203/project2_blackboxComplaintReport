package com.ssafy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.domain.User;
import com.ssafy.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository repo;

	@Override
	public User login(User user) throws Exception {
		return repo.select(user);
	}
	
	
}
