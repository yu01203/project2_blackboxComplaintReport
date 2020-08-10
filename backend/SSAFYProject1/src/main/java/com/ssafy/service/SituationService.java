package com.ssafy.service;

import java.util.List;

import com.ssafy.domain.Situation;
import com.ssafy.domain.Test;

public interface SituationService {
	//List<Situation> selectAll(String date) throws Exception;
	
	List<List<Test>> selectAll() throws Exception;
	List<List<Test>> selectByUser(int userno) throws Exception;
}
