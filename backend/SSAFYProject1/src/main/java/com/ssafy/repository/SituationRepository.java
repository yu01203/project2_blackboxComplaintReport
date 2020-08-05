package com.ssafy.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.ssafy.domain.Situation;

@Repository
public interface SituationRepository {
	List<Situation> selectAll(String date) throws Exception;
}
