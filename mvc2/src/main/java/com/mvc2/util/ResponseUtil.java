package com.mvc2.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

import com.mvc2.vo.ResultVO;

public class ResponseUtil {

	private static final String RESULT_CODE = "resultCode";
	private static final String RESULT_MSG = "resultMsg";
	private static final String RESULT_DATA = "resultData";
	
	public static ModelAndView ViewResponse(String view, ResultVO result) 
	{
		int code = result.getResultCode();
		String msg = result.getResultMsg();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName(view);
		mv.setStatus(HttpStatus.valueOf(code));
		mv.addObject(RESULT_CODE, code);
		mv.addObject(RESULT_MSG, msg);
		mv.addObject(RESULT_DATA, result.getResultData());
		if(code < 200 || code >= 300) {
			mv.addObject(RESULT_DATA, null);
		}
		return mv;
	}
	
	public static ResponseEntity<?> AjaxResponse(ResultVO result) 
	{
		int code = result.getResultCode();
		if(code < 200 || code >= 300) {
			result.setResultData(null);
		}
		return new ResponseEntity<>(result, HttpStatus.valueOf(code));
	}
}
