package com.springlec.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.KHomeDto;
import com.springlec.base.service.KHomeDaoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class KHomeController {

	@Autowired
	KHomeDaoService service;
	// 메인 페이지
	@RequestMapping("/")
	public String list(Model model) throws Exception{
		List<KHomeDto> listHomeDao = service.listHomeDao();
		model.addAttribute("list", listHomeDao);
		return "KHome" ;
	}
	// 로그인 페이지
	@RequestMapping("/loginView")
	public String loginView() throws Exception{
		return "KLogin";
	}
	// 로그아웃
	@RequestMapping("/logout")
	public String HomeView(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession(true);
		session.invalidate();
		return "redirect:/";
	}
	// 아이디찾기 페이지
	@RequestMapping("/findId")
	public String findId() throws Exception{
		return "KFindId";
	}
	// 비밀번호찾기 페이지
	@RequestMapping("/findPw")
	public String findPw() throws Exception{
		return "KFindpw";
	}

	
	

	

}
