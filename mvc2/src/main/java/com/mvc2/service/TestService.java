package com.mvc2.service;

import java.util.List;
import java.util.Map;

public interface TestService {
	
	public Map<String,Object> test(Map<String, Object> param);

	public List<Map<String,Object>> test2(Map<String, Object> param);
}
