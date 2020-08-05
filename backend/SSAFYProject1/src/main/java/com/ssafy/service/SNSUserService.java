package com.ssafy.service;

import com.ssafy.domain.SNSUser;

public interface SNSUserService {
	SNSUser login(SNSUser user) throws Exception;

	SNSUser detail(String email) throws Exception;

	int signUp(SNSUser user) throws Exception;

	int modify(SNSUser user) throws Exception;

	int remove(String email) throws Exception; // 리스트로 회원을 한꺼번에 remove 할지 고민
}
