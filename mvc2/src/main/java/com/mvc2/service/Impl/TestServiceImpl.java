package com.mvc2.service.Impl;

import java.util.List;
import java.util.Map;

import com.mvc2.mapper.Mapper;
import com.mvc2.service.TestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{

	@Autowired
	private Mapper mapper;
	
	@Override
	public Map<String, Object> test(Map<String, Object> param) {
		Map<String, Object> result = mapper.selectbbs(param);
		return result;
	}

	@Override
	public List<Map<String, Object>> test2(Map<String, Object> param) {
		
		List<Map<String, Object>> result = mapper.selectbbsList(param);
		// TODO Auto-generated method stub
		return result;
	}
	
	

}
