package com.ssafy.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.domain.Violation;
import com.ssafy.service.UserService;
import com.ssafy.service.ViolationService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("api/violation")
public class ViolationController {

	@Autowired
	UserService userService;
	@Autowired
	ViolationService violationService;

	@GetMapping()
	public List<Violation> viewViolaions(@RequestBody Map<String, Object> param) throws Exception {
		System.out.println("신고 정보 리스트 조회");

		// 이메일로 회원번호 조회
		int userNo = userService.detail(param.get("email").toString()).getUserNo();
		List<Violation> violationList = violationService.viewViolationList(userNo);

		return violationList;
	}

	@GetMapping("{userNo}/{violationNo}")
	public Violation viewViolation(@PathVariable int userNo, @PathVariable int violationNo) throws Exception {
		Violation violation = violationService.viewViolation(violationNo, userNo);

		return violation;
	}

	@PostMapping
	public String addViolation() throws Exception {
		return null;
	}

	@PutMapping
	public String modifyViolation() throws Exception {
		return "";
	}

	@DeleteMapping
	public String removeViolation() throws Exception {
		return "";
	}
}
