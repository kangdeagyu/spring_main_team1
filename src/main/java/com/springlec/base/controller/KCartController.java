package com.springlec.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.KCartDto;
import com.springlec.base.service.KCartDaoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class KCartController {

	@Autowired
	KCartDaoService service;
	
	// 장바구니
	@RequestMapping("/KUserCartView")
	public String KUserCartView(HttpServletRequest request, Model model) throws Exception{
		HttpSession session = request.getSession(true);
		List<KCartDto> cartList = service.userCart((String)session.getAttribute("cid"));
		
		model.addAttribute("list", cartList);
		return "KUserCartView";
	}
	
}
