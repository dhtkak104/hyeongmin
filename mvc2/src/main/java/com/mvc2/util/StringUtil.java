package com.mvc2.util;

public class StringUtil {

	public static String fixNull(Object obj) {
		if(obj == null) {
			return "";
		}
		return obj.toString();
	}

	public static String fixNull(Object obj, String str) {
		if(obj == null) {
			return str;
		}
		return obj.toString();
	}
}
