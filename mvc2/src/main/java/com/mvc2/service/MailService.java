package com.mvc2.service;

import java.util.Map;

public interface MailService {

	public void sendGoogle(Map<String, Object> param);
	public void sendNaver(Map<String, Object> param);
}
