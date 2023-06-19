package com.springlec.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.KJJdetailPageDto;
import com.springlec.base.service.KJJdetailPageDaoService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class KJJdetailPageController {

	@Autowired
	KJJdetailPageDaoService service;
	
	@RequestMapping("/detailPage")
	public String listKJJdetailPageDao(HttpServletRequest request, Model model) throws Exception{
		List<KJJdetailPageDto> listKJJdetailPageDao = service.listKJJdetailPageDao(Integer.parseInt(request.getParameter("pid")));
		model.addAttribute("listdetailPage", listKJJdetailPageDao);
		return "detailedpage" ;	}
}
