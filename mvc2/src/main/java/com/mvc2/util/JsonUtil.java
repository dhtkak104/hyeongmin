package com.mvc2.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

	@SuppressWarnings("unchecked")
	public static Map<String,Object> toMapObject(String jsonStr) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		ObjectMapper mapper = new ObjectMapper();
		try {
			map = (Map<String, Object>)mapper.readValue(jsonStr, new TypeReference<Map<String, Object>>() {});
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		return map;
	}
	
	public static String toJson(Object obj) 
	{
		ObjectMapper mapper = new ObjectMapper();
	    String json = "";
	    try {
	      json = mapper.writer().writeValueAsString(obj); 
	    } 
	    catch (IOException e) {
	    	e.printStackTrace();
	    } 
	    return json;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Map<String,Object>> toList(String jsonStr) {
		List<Map<String,Object>> list = null;
		ObjectMapper mapper = new ObjectMapper();
		try {	
			list = (List<Map<String,Object>>)mapper.readValue(jsonStr, List.class);
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		return list;
	}
	
	public static String toList(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {	
			json = mapper.writer().writeValueAsString(obj);
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		return json;
	}
}
