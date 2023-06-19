package com.springlec.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.service.KOrderDaoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class KOrderController {

	@Autowired
	KOrderDaoService service;
	
	// 상품구매
	@RequestMapping("/userOrderProduct")
	public void userOrderProduct(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession(true);
		String[] bid = (String[]) session.getAttribute("bid");
		String cid = (String)session.getAttribute("cid");
		String[] pid = request.getParameterValues("pid[]");
		String[] qty = request.getParameterValues("qty[]");
		String[] price = request.getParameterValues("price[]");
		String postnum = request.getParameter("cpostnum");
		String address1 = request.getParameter("caddress1");
		String address2 = request.getParameter("caddress2");
		String memo = request.getParameter("memo");
		String payment = request.getParameter("payment");
		String cname = request.getParameter("cname");
		String cphone = request.getParameter("cphone");
		
	}
	
	
	
	
}// end

