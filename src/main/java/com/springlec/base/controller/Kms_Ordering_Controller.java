package com.springlec.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.Kms_Ordering_Dto;
import com.springlec.base.service.Kms_Ordering_Service;

import jakarta.mail.Session;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class Kms_Ordering_Controller {

	@Autowired
	Kms_Ordering_Service service;
	// 주문내역 불러오기
	@RequestMapping("/orderinglist")
	public String orderinglist(HttpServletRequest request, Model model) throws Exception{
		HttpSession session = request.getSession(true);
		List<Kms_Ordering_Dto> list = service.orderinglist((String)session.getAttribute("cid"));
		model.addAttribute("Olist",list);
		return "Kms_OrderingList";
	}
	// 환불 요청하기
	@RequestMapping("/orderRefund")
	public String orderRefund(HttpServletRequest request, Model model) throws Exception{
		service.orderRefund(Integer.parseInt(request.getParameter("oid")));
		return "redirect:Kms_OrderingList";
	}
}
