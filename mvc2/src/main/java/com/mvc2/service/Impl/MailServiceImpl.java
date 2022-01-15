package com.mvc2.service.Impl;

import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import com.basic.service.MailService;
import com.basic.util.StringUtil;

@Service
public class MailServiceImpl implements MailService{

	private static final String G_ID = "dhtkak14@gmail.com";
	private static final String G_PW = "password";
	private static final String G_HOST = "smtp.gmail.com";
	private static final int G_PORT = 465;
	
	private static final String N_ID = "dhtkak104@naver.com";
	private static final String N_PW = "password";
	private static final String N_HOST = "smtp.naver.com";
	private static final int N_PORT = 587;
	
	@Override
	public void sendGoogle(Map<String, Object> param) {
		param.put("user", G_ID);
		param.put("password", G_PW);
		param.put("type", "G");
		send(param);
	}

	@Override
	public void sendNaver(Map<String, Object> param) {
		param.put("user", N_ID);
		param.put("password", N_PW);
		param.put("type", "N");
		send(param);
	}

	private void send(Map<String, Object> param) {
		String type = StringUtil.fixNull(param.get("type"));
		// SMTP 설정
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		if("G".equals(type)) 
		{
			prop.put("mail.smtp.host", G_HOST); 
			prop.put("mail.smtp.port", G_PORT); 
			prop.put("mail.smtp.ssl.enable", "true"); 
			prop.put("mail.smtp.ssl.trust", G_HOST);
		} 
		else {
			prop.put("mail.smtp.host", N_HOST); 
			prop.put("mail.smtp.port", N_PORT); 
		}
		
		String user = StringUtil.fixNull(param.get("user"));
		String password = StringUtil.fixNull(param.get("password"));
		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });
		
		try 
		{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));

            String[] receiverList = (String[]) param.get("receiverList");
            InternetAddress[] toAddr = new InternetAddress[receiverList.length];
            for(String receiver : receiverList) {
            	toAddr[0] = new InternetAddress(receiver);
            }
            
            //수신자메일주소
            message.addRecipients(Message.RecipientType.TO, toAddr); 
            message.setSubject(StringUtil.fixNull(param.get("subject"))); 
            message.setContent(StringUtil.fixNull(param.get("contents")), "text/html;charset=euc-kr");  // message.setText : html 아닌 텍스트
            
            Transport.send(message);
        } 
		catch (Exception e) {
            e.printStackTrace();
        }
	}
	
}
