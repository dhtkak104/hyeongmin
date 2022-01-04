package com.mvc2.service;

import java.util.Map;

import com.mvc2.vo.ResultVO;

public interface HttpConnectionService {

	public ResultVO sendGet(String url);
	public ResultVO sendGet(String url, Map<String, Object> param);
	public ResultVO sendPost(String url);
	public ResultVO sendPost(String url, Map<String, Object> param);
}
