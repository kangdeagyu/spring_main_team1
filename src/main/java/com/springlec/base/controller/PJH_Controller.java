package com.springlec.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.PJH_ProductDto;
import com.springlec.base.service.PJH_ProductDao_Service;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PJH_Controller {

	@Autowired
	PJH_ProductDao_Service service;
	
	
	@RequestMapping("/APlist.do")
	public String productList(Model model) throws Exception{
		List<PJH_ProductDto> list = service.productList();
		model.addAttribute("list", list);
		return "Admin_ProductList_pjh";
	}
	
	
	
	
	
	
	
}
