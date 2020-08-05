package com.ssafy.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.domain.Violation;

@Repository
public interface SNSViolationRepository {
	Violation select(int violationNo, int userNo) throws Exception;

	List<Violation> selectAll(int userNo) throws Exception;

	int insert(Violation violation) throws Exception;

	int update(Violation violation) throws Exception;

	int delete(int violationNo, int userNo) throws Exception;
}
