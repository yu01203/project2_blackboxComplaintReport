package com.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssafy.domain.Situation;
import com.ssafy.repository.SituationRepository;

@Service
public class SituationServiceImpl implements SituationService {
	
	@Autowired
	SituationRepository repo;
	
	@Override
	public List<Situation> selectAll(String date) throws Exception {
		return repo.selectAll(date);
	}

}
