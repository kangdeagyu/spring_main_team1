package com.springlec.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.service.KJJBasketDaoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class KJJBasketController {

@Autowired
KJJBasketDaoService service;
	

@RequestMapping("/KUserCartViewKJJ")
public String BasketDao(HttpServletRequest request) throws Exception{
	HttpSession session = request.getSession();
	
	service.BasketDao(Integer.parseInt(request.getParameter("pid")), (String)session.getAttribute("cid") , Integer.parseInt(request.getParameter("qty")));
	System.out.println(Integer.parseInt(request.getParameter("pid")));
	System.out.println((String)session.getAttribute("cid"));
	System.out.println(Integer.parseInt(request.getParameter("qty")));
	return "redirect:KUserCartView";

}

}
