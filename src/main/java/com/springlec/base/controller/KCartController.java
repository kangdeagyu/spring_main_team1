package com.springlec.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	
}// end

