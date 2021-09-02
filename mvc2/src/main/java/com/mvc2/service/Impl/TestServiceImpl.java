package com.mvc2.service.Impl;

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
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
