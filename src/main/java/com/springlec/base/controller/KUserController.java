package com.springlec.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springlec.base.service.KUserDaoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class KUserController {

	@Autowired
	KUserDaoService service;
	
	// 로그인 체크 유저파트
	@RequestMapping("/loginCheck")
	@ResponseBody
	public String userCheck(HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession(true);
		String result = service.userCheck(request.getParameter("username"),request.getParameter("password"));
		if(!result.equals("error") && !result.equals("mdraw")) {
			session.setAttribute("cid", request.getParameter("username"));
			session.setAttribute("name", result);			
		}
		
		return result;
		
	}
	
	// 회원가입 창
	@RequestMapping("/joinView")
	public String joinView() throws Exception{
		return "KJoin";
	}
	
	// 이메일 중복 체크
	@RequestMapping("/emailCheck")
	@ResponseBody
	public int emailCheck(HttpServletRequest request) throws Exception{
		int result = service.emailCheck(request.getParameter("email"));
		return result;
	}
	
	// 회원가입
	@RequestMapping("/joinUser")
	@ResponseBody
	public int joinUser(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");
		String cid = request.getParameter("email");
		String cpassword = request.getParameter("password");
		String cname = request.getParameter("name");
		String cphone = request.getParameter("phone");
		String cbirth = request.getParameter("cbirth");
		String cgender = request.getParameter("genderInputs");
		String cpostnum = request.getParameter("cpostnum");
		String caddress1 = request.getParameter("caddress1");
		String caddress2 = request.getParameter("caddress2");
		int gender = 0;
		
		if(cgender.equals("male")) {
			gender = 1;
		}else {
			gender = 0;
		}

		int result = service.joinUser(cid, cpassword, cname, cphone, cbirth, gender, cpostnum, caddress1, caddress2);
	    return result;
		
	}
	
	
	
} // end

