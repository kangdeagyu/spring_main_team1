package com.springlec.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.KJJdetailPageDto;
import com.springlec.base.service.KJJdetailPageDaoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class KJJdetailPageController {

	@Autowired
	KJJdetailPageDaoService service;
	
	@RequestMapping("/detailPage")
	public String listKJJdetailPageDao(HttpServletRequest request, Model model) throws Exception{
		HttpSession session = request.getSession(true);
		List<KJJdetailPageDto> listKJJdetailPageDao = service.listKJJdetailPageDao(Integer.parseInt(request.getParameter("pid")));
//		List<KJJdetailPageDto> customerDao = service.customerDao((String) session.getAttribute("cid"));
		model.addAttribute("listdetailPage", listKJJdetailPageDao);
		return "detailedpage" ;	
		}
}
