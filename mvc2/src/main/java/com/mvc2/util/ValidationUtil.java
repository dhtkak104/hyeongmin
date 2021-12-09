package com.mvc2.util;

import java.util.Collection;
import java.util.Map;

import com.mvc2.define.ResultCode;
import com.mvc2.define.ResultMsg;
import com.mvc2.vo.ResultVO;

public class ValidationUtil {

	public static boolean isEmpty(Object o) {
        if (o == null) {
            return true;
        }
        else if (o instanceof String && ((String) o).trim().length() == 0) {
            return true;
        }
        else if (o instanceof String && ((String) o).equalsIgnoreCase("NULL")) {
            return true;
        }
        else if (o instanceof Collection && ((Collection<?>) o).isEmpty()) {
            return true;
        }
        else if (o instanceof Map && ((Map<?, ?>) o).isEmpty()) {
            return true;
        }
        else if (o instanceof Object[] && ((Object[]) o).length == 0) {
            return true;
        }
        else if (o instanceof Character && (Character) o == ' ') {
            return true;
        }
        return false;
    }
	
	public static ResultVO isValidation(String[] essentialKeys, Map<String,Object> param) 
	{
		ResultVO resultVO = new ResultVO();
		if(isEmpty(param)) {
			resultVO.setResultCode(ResultCode.BAD_REQUEST);
			resultVO.setResultMsg(ResultMsg.BAD_REQUEST_PARAM);
		} 
		
		String emptyStr = "";
		for(String essentialKey : essentialKeys) {
			boolean flag = true; // 필수값 존재여부 확인 flag
			for (Object key : param.keySet()) {
				String keyStr = StringUtil.fixNull(key);
				if (essentialKey.equals(keyStr) && !isEmpty(param.get(key))) {
					flag = false;
					break;
				} 
			} 
			
			if(flag) 
			{
				if(isEmpty(emptyStr)) {
					emptyStr = " [" + essentialKey;
				}
				else {
					emptyStr = emptyStr + ", " + essentialKey;
				}
			}
		} 
		
		if(!isEmpty(emptyStr)) {
			resultVO.setResultCode(ResultCode.BAD_REQUEST);
			resultVO.setResultMsg(ResultMsg.BAD_REQUEST_PARAM + emptyStr + "]");
		} 
		return resultVO;
	}
}
