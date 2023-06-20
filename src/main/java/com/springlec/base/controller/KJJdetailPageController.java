package com.springlec.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.KJJdetailPageDto;
import com.springlec.base.model.Kms_Forum_Dto;
import com.springlec.base.service.KJJdetailPageDaoService;
import com.springlec.base.service.Kms_Forum_Service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class KJJdetailPageController {

	@Autowired
	KJJdetailPageDaoService service;
	@Autowired
	Kms_Forum_Service dservice;
	
	@RequestMapping("/detailPage")
	public String listKJJdetailPageDao(HttpServletRequest request, Model model) throws Exception{
		HttpSession session = request.getSession(true);
		List<KJJdetailPageDto> listKJJdetailPageDao = service.listKJJdetailPageDao(Integer.parseInt(request.getParameter("pid")));
//		List<KJJdetailPageDto> customerDao = service.customerDao((String) session.getAttribute("cid"));
		model.addAttribute("listdetailPage", listKJJdetailPageDao);
		List<Kms_Forum_Dto> DQnAList = dservice.DQnAList(Integer.parseInt(request.getParameter("pid")));
		model.addAttribute("Qdto",DQnAList);
		List<Kms_Forum_Dto> DReviewList = dservice.DReviewList(Integer.parseInt(request.getParameter("pid")));
		model.addAttribute("Rdto",DReviewList);
		return "detailedpage" ;	
		}
	
	@RequestMapping("/QnAWrite")
	public String QnAwrite(HttpServletRequest request, Model model) throws Exception{
		Kms_Forum_Dto QnAPname = dservice.QnAPname(Integer.parseInt(request.getParameter("pid")));
		model.addAttribute("Pname",QnAPname);
		return "Kms_QnAWrite";
	}
}
