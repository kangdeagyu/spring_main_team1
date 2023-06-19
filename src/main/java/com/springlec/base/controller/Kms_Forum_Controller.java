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
	
	@RequestMapping("/writeforum")
	public String writeforum(HttpServletRequest request, Model model) throws Exception{
		service.writeforum(request.getParameter("f_cid"), Integer.parseInt(request.getParameter("f_pid")), request.getParameter("ftitle"), request.getParameter("fcontent"));
		return "redirect:list";
	}
	
	@RequestMapping("/forumview")
	public String forumview(HttpServletRequest request, Model model) throws Exception{
		Kms_Forum_Dto forumview = service.forumview(Integer.parseInt(request.getParameter("fid")));
		model.addAttribute("forumview",forumview);
		return "ForumView";
	}
	
	@RequestMapping("/forumview")
	public String commentlist(HttpServletRequest request, Model model) throws Exception{
		List<Kms_Forum_Dto> commentlist = service.commentlist(Integer.parseInt(request.getParameter("fid")));
		model.addAttribute("commentlist",commentlist);
		return "FormView";
	}
}
