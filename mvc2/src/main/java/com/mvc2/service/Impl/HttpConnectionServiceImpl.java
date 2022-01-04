package com.mvc2.service.Impl;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import com.mvc2.define.ResultCode;
import com.mvc2.define.ResultMsg;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mvc2.service.HttpConnectionService;
import com.mvc2.util.JsonUtil;
import com.mvc2.util.StringUtil;
import com.mvc2.vo.ResultVO;

@Service
public class HttpConnectionServiceImpl implements HttpConnectionService{
	
	@Override
	public ResultVO sendGet(String url) {
		return sendApiSync(url, "GET", new HashMap<String, Object>());
	}

	@Override
	public ResultVO sendGet(String url, Map<String, Object> param) {
//		url = getUrlQueryString(url, param);
//		return sendApiSync(url, "GET", param);
		ResultVO result = new ResultVO();
		String jsonStr = "{\"dataSearch\":{\"content\":[{\"link\":\"http://gageodo.es.jne.kr/\",\"adres\":\"전라남도 신안군 흑산면 가거도길 18-31(흑산면)\",\"schoolName\":\"가거도초등학교\",\"region\":\"전라남도\",\"totalCount\":\"5\",\"estType\":\"\",\"seq\":\"4491\"},{\"link\":\"http://school.cbe.go.kr/gagyeong-e/M01/\",\"adres\":\"충청북도 청주시 흥덕구 장구봉로 93(복대동, 가경초등학교)\",\"schoolName\":\"가경초등학교\",\"region\":\"충청북도\",\"totalCount\":\"5\",\"estType\":\"\",\"seq\":\"3303\"},{\"link\":\"http://www.gagopa-p.gne.go.kr\",\"adres\":\"경상남도 창원시 마산회원구 삼호로 110(양덕동, 가고파초등학교)\",\"schoolName\":\"가고파초등학교\",\"region\":\"경상남도\",\"totalCount\":\"5\",\"estType\":\"\",\"seq\":\"6496\"},{\"link\":\"http://school.cbe.go.kr/gagok-e/\",\"adres\":\"충청북도 단양군 가곡면 남한강로 548, 가곡초등학교 (가곡면)\",\"schoolName\":\"가곡초등학교\",\"region\":\"충청북도\",\"totalCount\":\"5\",\"estType\":\"\",\"seq\":\"3304\"},{\"link\":\"http://gagok.es.kr\",\"adres\":\"경기도 남양주시 화도읍 비룡로379번길 3(화도읍, 가곡초등학교)\",\"schoolName\":\"가곡초등학교\",\"region\":\"경기도\",\"totalCount\":\"5\",\"estType\":\"\",\"seq\":\"1724\"}]}}";
		Map<String, Object> dummyData = JsonUtil.toMapObject(jsonStr);
		
		result.setResultData(dummyData);
		result.setResultCode(ResultCode.SUCCESS);
		result.setResultMsg(ResultMsg.SUCCESS);
		return result;
	}

	@Override
	public ResultVO sendPost(String url) {
		return sendApiSync(url, "POST", new HashMap<String, Object>());
	}

	@Override
	public ResultVO sendPost(String url, Map<String, Object> param) {
		return sendApiSync(url, "POST", param);
	}
	
	@SuppressWarnings({ "unchecked" })
	private ResultVO sendApiSync(String url, String method, Map<String, Object> param) 
	{
		ResultVO luluResult = new ResultVO();
		int responseCode = 500;
		
		System.out.println("url: " + url);
		try 
		{
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection)obj.openConnection();
			con.setConnectTimeout(5000);
			con.setReadTimeout(60000);
			con.setRequestMethod(method.toUpperCase());
			con.setRequestProperty("Content-Type", "application/json; charset=utf-8");
			
			if("POST".equalsIgnoreCase(method))  
			{
				con.setDoOutput(true);
				String paramStr = JsonUtil.toJson(param);
			    System.out.println("request paramStr : " + paramStr);
			     
			    DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			    wr.write(paramStr.getBytes("utf-8"));
			    wr.flush();
			    wr.close();
			}
			
			responseCode = con.getResponseCode();
			System.out.println("response code : " + responseCode);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			StringBuffer response = new StringBuffer();
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			System.out.println("response value : " + response.toString());
			
			ObjectMapper mapper = new ObjectMapper();
			try {
				Map<String, Object> map = (Map<String, Object>)mapper.readValue(response.toString(), new TypeReference<Map<String, Object>>() {});
				luluResult.setResultData(map);
			} 
			catch (IOException e) {
				luluResult.setResultData(response.toString());
			}
			finally {
				luluResult.setResultCode(responseCode);
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
			luluResult.setResultCode(responseCode);
		} 
		return luluResult;
	}
	
	@SuppressWarnings("rawtypes")
	private String getUrlQueryString(String url, Map<String,Object> param) {
		String paramStr = "";
		Iterator<Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = it.next();
			String key = StringUtil.fixNull(entry.getKey());
			String val = StringUtil.fixNull(entry.getValue());
        	
			try 
			{
				if(paramStr.length() > 0) {
					paramStr += "&";
				}
				paramStr += key + "=" + URLEncoder.encode(val, "UTF-8");
			} 
        	catch (UnsupportedEncodingException e) {
				paramStr = "";
			}
		}
		
		if(url.lastIndexOf("?") == url.length()) { // url : www.naver.com?
			url += paramStr;
		} 
		else if(url.lastIndexOf("?") > -1) { // url : www.naver.com?abc=1
			url += "&" + paramStr;
		} 
		else { // url : www.naver.com
			url += "?" + paramStr;
		}
		return url;
	}
}
