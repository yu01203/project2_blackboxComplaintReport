package com.ssafy.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.ssafy.domain.Situation;

@Repository
public interface SituationRepository {
	List<Situation> select0() throws Exception;

	List<Situation> select1() throws Exception;

	List<Situation> select2() throws Exception;

	List<Situation> selectByUser0(int userno) throws Exception;

	List<Situation> selectByUser1(int userno) throws Exception;

	List<Situation> selectByUser2(int userno) throws Exception;
}
