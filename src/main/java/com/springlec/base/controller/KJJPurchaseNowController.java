package com.springlec.base.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.service.KJJPurchaseNowDaoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class KJJPurchaseNowController {

	
	@Autowired
	KJJPurchaseNowDaoService service;
	
	@RequestMapping("purchaseNow")
	public String purchase(HttpServletRequest request) throws Exception{
		System.out.println("들어왔다");
		HttpSession session = request.getSession(true);
////	
////		service.purchaseNow((String)session.getAttribute("cid"), ((int)session.getAttribute("pid")),
////				Integer.parseInt(request.getParameter("qty")), Integer.parseInt(request.getParameter("price")),
////				request.getParameter("cpostnum"), 
////				request.getParameter("caddress1"), request.getParameter("caddress2"), request.getParameter("memo"), 
////				request.getParameter("payment"));

		String cid = (String) session.getAttribute("cid");
		int pid = Integer.parseInt(request.getParameter("pid"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		int price = Integer.parseInt(request.getParameter("price"));
		String postnum = request.getParameter("cpostnum");
		String address1 = request.getParameter("caddress1");
		String address2 = request.getParameter("caddress2");
		String memo = request.getParameter("memo");
		String payment = request.getParameter("payment");
//		
		System.out.println(cid);
		System.out.println(pid);
		System.out.println(qty);
		System.out.println(price);
		System.out.println(postnum);
		System.out.println(address1);
		System.out.println(address2);
		System.out.println(memo);
		System.out.println(payment);
//		
//		
		service.PurchaseNowDao(cid, pid, qty, price, postnum, address1, address2, memo, payment);
		service.prodcutQtyModify(pid, qty);
			return "KOrderCompleted";
	
}

}