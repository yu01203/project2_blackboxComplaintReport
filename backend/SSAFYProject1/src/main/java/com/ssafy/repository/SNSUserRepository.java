package com.ssafy.repository;

import org.springframework.stereotype.Repository;

import com.ssafy.domain.SNSUser;

@Repository
public interface SNSUserRepository {
	SNSUser select(SNSUser user) throws Exception;

	SNSUser selectUser(String email) throws Exception;

	int insert(SNSUser user) throws Exception;

	int update(SNSUser user) throws Exception;

	int delete(String email) throws Exception;
}
