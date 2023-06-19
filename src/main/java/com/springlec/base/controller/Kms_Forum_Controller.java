package com.springlec.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.Kms_Forum_Dto;
import com.springlec.base.service.Kms_Forum_Service;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class Kms_Forum_Controller {

	@Autowired
	Kms_Forum_Service service;
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) throws Exception{
		List<Kms_Forum_Dto> list = service.list(Integer.parseInt(request.getParameter("ftype")));
		model.addAttribute("list",list);
		return "Kms_WriteList";
	}
}
