package com.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.domain.Violation;
import com.ssafy.repository.ViolationRepository;

@Service
public class ViolationServiceImpl implements ViolationService {
	
	@Autowired
	ViolationRepository repository;

	@Override
	public Violation viewViolation(int violationNo, int userNo) throws Exception {
		return repository.select(violationNo, userNo);
	}

	@Override
	public List<Violation> viewViolationList(int userNo) throws Exception {
		return repository.selectAll(userNo);
	}

	@Override
	public int addViolation(Violation violation) throws Exception {
		return repository.insert(violation);
	}

	@Override
	public int modifyViolation(Violation violation) throws Exception {
		return repository.update(violation);
	}

	@Override
	public int removeViolation(int violationNo, int userNo) throws Exception {
		return repository.delete(violationNo, userNo);
	}

}
