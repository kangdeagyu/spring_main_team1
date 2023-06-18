package com.springlec.base.config;

import java.util.Properties;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springlec.base.service.KEmailSendService;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;



@Configuration
public class KSendEmailConfig {

	@Bean
	public KEmailSendService emailSendService() {
		return new KEmailSendService() {
			
			@Override
			public void sendEmail(String email, String sendCode) throws Exception {
				// TODO Auto-generated method stub
		        final String username = "rkdeorb1478@gmail.com";
		        final String password = "zulwebgvyrglhsmv";
		        String from = "rkdeorb1478@gmail.com";
		        String to = email;
		        String ecode = sendCode;
		        
		        
		        
		        String host = "smtp.gmail.com";
		        int port = 587;

		        Properties properties = new Properties();
		        properties.put("mail.smtp.host", host);
		        properties.put("mail.smtp.port", port);
		        properties.put("mail.smtp.auth", "true");
		        properties.put("mail.smtp.starttls.enable", "true");
		        properties.put("mail.smtp.ssl.protocols", "TLSv1.3");
		        properties.put("mail.smtp.ssl.ciphersuites", "TLS_AES_128_GCM_SHA256");


		        Session session = Session.getInstance(properties, new Authenticator() {
		            protected PasswordAuthentication getPasswordAuthentication() {
		                return new PasswordAuthentication(username, password);
		            }
		        });

		        try {
		            MimeMessage message = new MimeMessage(session);
		            message.setFrom(new InternetAddress(from));
		            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		            message.setSubject("Little and Precious 인증번호 입니다.");
		            message.setText("인증번호 : " + ecode);

		            Transport.send(message);
		           
		        } catch (MessagingException mex) {
		            mex.printStackTrace();
		        }
			}
		};
	}

}
