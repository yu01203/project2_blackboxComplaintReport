package com.ssafy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.service.SituationService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("api/situation")
public class SituationController {

	@Autowired
	SituationService service;

	@ApiOperation(value = "현황 정보를 리스트로 반환한다.", response = List.class)
	@GetMapping
	public String viewSituation(String date) {
		
		try {
			service.selectAll(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

}
