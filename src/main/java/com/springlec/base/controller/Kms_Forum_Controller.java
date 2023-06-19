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
		return "redirect:Kms_WriteList";
	}
	
	@RequestMapping("/forumview")
	public String forumview(HttpServletRequest request, Model model) throws Exception{
		Kms_Forum_Dto forumview = service.forumview(Integer.parseInt(request.getParameter("fid")));
		model.addAttribute("forumview",forumview);
		List<Kms_Forum_Dto> commentlist = service.commentlist(Integer.parseInt(request.getParameter("fid")));
		model.addAttribute("commentlist",commentlist);
		return "ForumView";
	}
	
	@RequestMapping("/commentAction")
	public String commentAction(HttpServletRequest request, Model model) throws Exception{
		service.commentAction(request.getParameter("f_cid"), Integer.parseInt(request.getParameter("f_pid")), request.getParameter("ftitle"), Integer.parseInt(request.getParameter("fid")));
		return "redirect:ForumView";
	}
	
	@RequestMapping("/commentDelete")
	public String commentDelete(HttpServletRequest request, Model model) throws Exception{
		service.commentDelete(Integer.parseInt(request.getParameter("fid")));
		return "redirect:ForumView";
	}
	
	@RequestMapping("/forumSearch")
	public String forumSearch(HttpServletRequest request, Model model) throws Exception{
		List<Kms_Forum_Dto> serchlist = service.forumSearch(Integer.parseInt(request.getParameter("ftype")), request.getParameter("content"));
		model.addAttribute("searchlist",serchlist);
		return "redirect:Kms_WriteList";
	}
	
	@RequestMapping("/QnAwrite")
	public String QnAwrite(HttpServletRequest request, Model model) throws Exception{
		service.QnAwrite(request.getParameter("f_cid"), Integer.parseInt(request.getParameter("f_pid")), request.getParameter("ftitle"), request.getParameter("fcontent"));
		return "";
	}
}
