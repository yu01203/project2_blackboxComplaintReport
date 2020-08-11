package com.ssafy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssafy.domain.Situation;
import com.ssafy.repository.SituationRepository;

@Service
public class SituationServiceImpl implements SituationService {
	
	@Autowired
	SituationRepository repo;
	
//	@Override
//	public List<Situation> selectAll(String date) throws Exception {
//		return repo.selectAll(date);
//	}
	@Override
	public List<List<Situation>> selectAll() throws Exception {
		
		List<List<Situation>> abc = new ArrayList<List<Situation>>();

		abc.add(repo.select0());
		abc.add(repo.select1());
		abc.add(repo.select2());	
		
		return abc;
	}
	
	@Override
	public List<List<Situation>> selectByUser(int userno) throws Exception {
		
		List<List<Situation>> abc = new ArrayList<List<Situation>>();

		abc.add(repo.selectByUser0(userno));
		abc.add(repo.selectByUser1(userno));
		abc.add(repo.selectByUser2(userno));	
	
		return abc;
	}

}
