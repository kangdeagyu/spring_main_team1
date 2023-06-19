package com.springlec.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springlec.base.model.KCartDto;
import com.springlec.base.model.KCartOrderDto;
import com.springlec.base.model.KUserDto;
import com.springlec.base.service.KCartDaoService;
import com.springlec.base.service.KCartOrderService;
import com.springlec.base.service.KUserDaoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class KCartController {

	@Autowired
	KCartDaoService service;
	@Autowired
	KUserDaoService userDaoService;
	@Autowired
	KCartOrderService cartOrderService;
	
	// 장바구니
	@RequestMapping("/KUserCartView")
	public String KUserCartView(HttpServletRequest request, Model model) throws Exception{
		HttpSession session = request.getSession(true);
		List<KCartDto> cartList = service.userCart((String)session.getAttribute("cid"));
		session.removeAttribute("orderList");
		session.removeAttribute("userlist");
		
		model.addAttribute("list", cartList);
		return "KUserCartView";
	}
	
	// 수량 변경
	@RequestMapping("/qtyChangeView")
	@ResponseBody
	public int qtyChangeView(HttpServletRequest request) throws Exception{
		int result = service.qtyChange(Integer.parseInt(request.getParameter("pid")), Integer.parseInt(request.getParameter("qty")));
		return result;
	}
	
	// 선택한 상품삭제
	@RequestMapping("/selectiondelete")
	@ResponseBody
	public int selectiondelete(HttpServletRequest request) throws Exception{
		int result = service.selectionDelete(request.getParameterValues("selectedBids"));
		return result;
	}
	
	// 장바구니 -> 구매페이지
	@RequestMapping("/selectionOrder")
	@ResponseBody
	public void selectionOrder(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession(true);
		List<KCartOrderDto> cartOrder = cartOrderService.cartOrder(request.getParameterValues("selectedBids"));
		List<KUserDto> userList = userDaoService.userList((String)session.getAttribute("cid"));
		
		session.setAttribute("orderList", cartOrder);
		session.setAttribute("userlist", userList);

	}
	
	// 구매페이지
	@RequestMapping("/KCartOrderView")
	public String KCartOrderView() {
		return "KCartOrderView";
	}
	
	
}// end

