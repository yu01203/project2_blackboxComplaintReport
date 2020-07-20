package com.ssafy.repository;

import org.springframework.stereotype.Repository;

import com.ssafy.domain.User;

@Repository
public interface UserRepository {
	User select(User user) throws Exception;
}
