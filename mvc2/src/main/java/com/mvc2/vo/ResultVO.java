package com.mvc2.vo;

import com.mvc2.define.ResultCode;
import com.mvc2.define.ResultMsg;

public class ResultVO {

	private int resultCode;  	
	private String resultMsg;
	private Object resultData;
	
	public ResultVO() {
		resultCode = ResultCode.SUCCESS;
		resultMsg = ResultMsg.SUCCESS;
	}
	
	public int getResultCode() {
		return resultCode;
	}
	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	public Object getResultData() {
		return resultData;
	}
	public void setResultData(Object resultData) {
		this.resultData = resultData;
	}
}
