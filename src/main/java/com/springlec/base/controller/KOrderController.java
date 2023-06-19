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
	public String userOrderProduct(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession(true);

		String cid = (String)session.getAttribute("cid");
		String[] pids = request.getParameterValues("pid[]");
		String[] qtys = request.getParameterValues("qty[]");
		String[] prices = request.getParameterValues("price[]");
		String postnum = request.getParameter("cpostnum");
		String address1 = request.getParameter("caddress1");
		String address2 = request.getParameter("caddress2");
		String memo = request.getParameter("memo");
		String payment = request.getParameter("payment");
		

		for (int i = 0; i <pids.length; i++) {
			int pid = Integer.parseInt(pids[i]);
			int qty = Integer.parseInt(qtys[i]);
			int price = Integer.parseInt(prices[i]);
			service.orderProduct(cid, pid, qty, price, postnum, address1, address2, memo, payment);
			service.cartDeleteProduct(pid);
			service.prodcutQtyModify(pid, qty);
		}
		
		
		return "KOrderCompleted";
		
	}
	
	
	
	
}// end

