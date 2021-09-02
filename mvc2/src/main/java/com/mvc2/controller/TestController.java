package com.mvc2.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mvc2.service.TestService;

@Controller
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@GetMapping("bbs-view/{bbsNo}")
	public ModelAndView test(Map<String, Object> map) {
		
		Map<String,Object> result = testService.test(map);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bbsDetail");
		mv.setStatus(HttpStatus.valueOf(200));
		mv.addObject("bbs", result);
		return mv;
	}

}
