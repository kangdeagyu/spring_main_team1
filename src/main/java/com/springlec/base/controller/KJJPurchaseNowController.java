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
	
	@RequestMapping("purchase")
	public String purchase(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession(true);
	
//		service.purchase((String)session.getAttribute("cid"), ((int)session.getAttribute("pid")),
//				Integer.parseInt(request.getParameter("oqty")), Integer.parseInt(request.getParameter("oprice")),
//				request.getParameter("cpostnum"), 
//				request.getParameter("caddress1"), request.getParameter("caddress2"), request.getParameter("memo"), 
//				request.getParameter("payment"));
		
		
		String cid = (String) session.getAttribute("cid");
		int pid = (int) session.getAttribute("pid");

		int qty = Integer.parseInt(request.getParameter("qty"));
		int price = Integer.parseInt(request.getParameter("pprice"));
		String postnum = request.getParameter("cpostnum");
		String address1 = request.getParameter("caddress1");
		String address2 = request.getParameter("caddress2");
		String memo = request.getParameter("memo");
		String payment = request.getParameter("payment");
		
		session.setAttribute("pid", pid); // pid를 세션에 설정
		session.setAttribute("cid", cid); // cid를 세션에 설정
//		for (int i = 0; i <pids.length; i++) {
//			int pid = Integer.parseInt(pids[i]);
//			int qty = Integer.parseInt(qtys[i]);
//			int price = Integer.parseInt(prices[i]);
			service.purchase(cid, pid, qty, price, postnum, address1, address2, memo, payment);
//			service.cartDeleteProduct(pid);
//			service.prodcutQtyModify(pid, qty);
//		
			
			
			return "KOrderCompleted";
	
}

}