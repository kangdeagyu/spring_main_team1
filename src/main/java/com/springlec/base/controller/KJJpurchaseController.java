package com.springlec.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.KJJdetailPageDto;
import com.springlec.base.model.KJJpurchaseDto;
import com.springlec.base.service.KJJpurchaseDaoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class KJJpurchaseController {

	@Autowired
	KJJpurchaseDaoService service;
	
	@RequestMapping("/KJJOrderView")
	public String product(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession(true);
		int qty = ((int)Integer.parseInt(request.getParameter("qty")));
		List<KJJpurchaseDto> product = service.product(Integer.parseInt(request.getParameter("pid")));
		session.setAttribute("orderList", product);
		List<KJJpurchaseDto> customer = service.customer((String) session.getAttribute("cid"));
		session.setAttribute("userlist", customer);
		session.setAttribute("qty", qty);
		System.out.println(Integer.parseInt(request.getParameter("pid")));
		System.out.println((String) session.getAttribute("cid"));
		System.out.println(Integer.parseInt(request.getParameter("qty")));
		return "KJJOrderView";
	
	
//	@RequestMapping("/KCartOrderView")
//	public String purchase(HttpServletRequest request, Model model) throws Exception{
//		List<KJJpurchaseDto> product = service.product(Integer.parseInt(request.getParameter("pid")));
//		model.addAttribute("orderList", product);
//		List<KJJpurchaseDto> customer = service.customer(request.getParameter("cid"));
//		model.addAttribute("list", customer);
//		return "OrderView" ;	
		
//	public String purchase(HttpServletRequest request, Model model, @PathVariable int pid, @PathVariable String cid) throws Exception{
//		HttpSession session = request.getSession(true);
//		List<KJJpurchaseDto> customer = service.customer((String)session.getAttribute("cid"));
//	    session.removeAttribute("list");
//	    model.addAttribute("userlist", customer);
//	    
//	    // Product 정보 가져오기
//	    List<KJJpurchaseDto> product = service.product((int)session.getAttribute("pid"));
//	    session.removeAttribute("orderList");
//	    model.addAttribute("orderList", product);
//	    
//	    session.setAttribute("pid", pid);
//	    session.setAttribute("cid", cid);
//	    
//	    return "KCartOrderView";
//		List<KJJpurchaseDto> productDao = service.productDao(Integer.parseInt(request.getParameter("pid")), Integer.parseInt(request.getParameter("cid")));
	}
}
	
//	@RequestMapping("/OrderView")
//	public String 
//}
