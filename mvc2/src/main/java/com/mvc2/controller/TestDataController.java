package com.mvc2.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mvc2.service.TestService;

@RestController
public class TestDataController {
	
	@Autowired
	private TestService testService;
	
//	@GetMapping("bbs/{bbsNo}")
//	public ResponseEntity<?> test(@RequestParam Map<String, Object> map, @PathVariable Object bbsNo) {
//		map.put("bbsNo", bbsNo);
//		Map<String,Object> result = testService.test(map);
//
//		return new ResponseEntity<>(result, HttpStatus.valueOf(200));
//	}

}
