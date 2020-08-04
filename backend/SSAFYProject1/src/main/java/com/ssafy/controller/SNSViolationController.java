package com.ssafy.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.ssafy.service.SNSViolationService;
import com.ssafy.service.UserService;

import io.swagger.annotations.ApiOperation;

// http://localhost:9999/ssafy/swagger-ui.html
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("api/snsViolation")
public class SNSViolationController {
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	UserService userService;
	@Autowired
	SNSViolationService snsViolationService;

	@ApiOperation(value = "모든 제보 정보를 리스트로 반환한다.", response = List.class)
	@GetMapping("{userNo}")
	public ResponseEntity<List<Violation>> viewViolaions(@PathVariable int userNo) throws Exception {
		logger.debug("신고 리스트 조회 - 호출");
		// 이메일로 회원번호 조회
		return new ResponseEntity<List<Violation>>(snsViolationService.viewViolationList(userNo), HttpStatus.OK);
	}

	@ApiOperation(value = "회원의 제보 정보를 리스트로 반환한다.", response = Violation.class)
	@GetMapping("{userNo}/{violationNo}")
	public ResponseEntity<Violation> viewViolation(@PathVariable int userNo, @PathVariable int violationNo) throws Exception {
		logger.debug("신고  조회 - 호출");
		Violation abc = snsViolationService.viewViolation(violationNo, userNo);
		System.out.println(abc.toString());
		return new ResponseEntity<Violation>(snsViolationService.viewViolation(violationNo, userNo), HttpStatus.OK);
	}

	@ApiOperation(value = "회원 제보 정보를 등록 후 성공 여부를 반환한다.")
	@PostMapping
	public ResponseEntity<String> addViolation(@RequestBody Violation violation) throws Exception {
		logger.debug("신고 정보 삽입 - 호출");
		
		if(snsViolationService.addViolation(violation) == 1) return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_ACCEPTABLE);
	}

	@ApiOperation(value = "회원 제보 정보를 수정 후 성공 여부를 반환한다.")
	@PutMapping
	public ResponseEntity<String> modifyViolation(@RequestBody Violation violation) throws Exception {
		logger.debug("신고 정보 수정 - 호출");
		
		if(snsViolationService.modifyViolation(violation) == 1) return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_ACCEPTABLE);
	}

	@ApiOperation(value = "회원 제보 정보를 삭제 후 성공 여부를 반환한다.")
	@DeleteMapping("{userNo}/{violationNo}")
	public ResponseEntity<String> removeViolation(@PathVariable int violationNo, @PathVariable int userNo) throws Exception {
		logger.debug("신고 정보 삭제 - 호출");
		
		if(snsViolationService.removeViolation(violationNo, userNo) == 1) return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_ACCEPTABLE);
	}
}