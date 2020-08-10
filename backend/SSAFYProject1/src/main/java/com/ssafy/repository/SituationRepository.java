package com.ssafy.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.ssafy.domain.Situation;
import com.ssafy.domain.Test;

@Repository
public interface SituationRepository {
	List<Test> select0() throws Exception;
	List<Test> select1() throws Exception;
	List<Test> select2() throws Exception;
	List<Test> selectByUser0(int userno) throws Exception;
	List<Test> selectByUser1(int userno) throws Exception;
	List<Test> selectByUser2(int userno) throws Exception;
}
