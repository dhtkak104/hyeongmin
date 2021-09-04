package com.mvc2.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mvc2.service.TestService;

@Controller
public class TestController {
	
	@Autowired
	private TestService testService;
	
	/* 127.0.0.1:8080/bbs/1?abc=123
	 * ?전: URL / ?후: 파라미터 
	 * URL에 있는 1을 꺼낼 때 end-point에 {}를 사용. 즉,{bbsNo} -> 1
	 * 
	 * */
	@GetMapping("bbs/{bbsNo}")
	public ModelAndView test(@RequestParam Map<String, Object> map, @PathVariable Object bbsNo) {
		map.put("bbsNo", bbsNo);
		Map<String,Object> result = testService.test(map);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bbsDetail");
		mv.setStatus(HttpStatus.valueOf(200));
		mv.addObject("bbs", result);
		return mv;
	}
	
	@GetMapping("bbs")
	public ModelAndView test2(@RequestParam Map<String, Object> map) {
		List<Map<String,Object>> result = testService.test2(map);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bbsList");
		mv.setStatus(HttpStatus.valueOf(200));
		mv.addObject("bbsList", result);
		return mv;
	}

	
	@GetMapping("bbs/{bbsNo}/update")
	public ModelAndView test3(@RequestParam Map<String, Object> map, @PathVariable Object bbsNo) {
		map.put("bbsNo", bbsNo);
		Map<String,Object> result = testService.test(map);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bbsUpdate");
		mv.setStatus(HttpStatus.valueOf(200));
		mv.addObject("bbs", result);
		return mv;
	}

}
