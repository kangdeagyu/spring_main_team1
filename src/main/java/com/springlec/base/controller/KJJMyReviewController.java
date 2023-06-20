package com.springlec.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.KJJMyReviewPageDto;
import com.springlec.base.service.KJJMyReviewPageDaoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class KJJMyReviewController {

	@Autowired
	KJJMyReviewPageDaoService service;
	
	@RequestMapping("myreview")
	public String MyReviewPageDao(HttpServletRequest request, Model model) throws Exception{
		HttpSession session = request.getSession();
		
		List<KJJMyReviewPageDto> MyReviewDao = service.MyReviewPageDao((String)session.getAttribute("cid"));
	model.addAttribute("Myreview", MyReviewDao);
	System.out.println((String) session.getAttribute("cid"));
		return "myreview";
}

}
