package com.ssafy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.domain.SNSUser;
import com.ssafy.repository.SNSUserRepository;

@Service
public class SNSUserServiceImpl implements SNSUserService {
	
	@Autowired
	SNSUserRepository repo;

	@Override
	public SNSUser login(SNSUser user) throws Exception {
		return repo.select(user);
	}

	@Override
	public SNSUser detail(String email) throws Exception {
		return repo.selectUser(email);
	}

	@Override
	public int signUp(SNSUser user) throws Exception {
		return repo.insert(user);
	}

	@Override
	public int modify(SNSUser user) throws Exception {
		return repo.update(user);
	}

	@Override
	public int remove(String email) throws Exception {
		return repo.delete(email);
	}
	
}
