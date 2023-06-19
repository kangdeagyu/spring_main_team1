package com.springlec.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springlec.base.service.KEmailSendService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class KSendEmailController {

	@Autowired
	KEmailSendService service;
	
	// 이메일 인증
	@RequestMapping("/sendEmail")
	@ResponseBody
	public void sendEmail(HttpServletRequest request) throws Exception{
		String email = request.getParameter("email");
		String code = request.getParameter("sendCode");


		service.sendEmail(email, code);
	}
}
