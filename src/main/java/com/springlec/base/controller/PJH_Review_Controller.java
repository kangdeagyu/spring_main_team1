package com.springlec.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springlec.base.model.PJH_ReviewDto;
import com.springlec.base.service.PJH_ReviewDao_Service;

@Controller
public class PJH_Review_Controller {

	@Autowired
	PJH_ReviewDao_Service service;
	
	//리뷰 리스트
	@RequestMapping("/AReviewList.do")
	public String reviewList(Model model) throws Exception{
		List<PJH_ReviewDto> list = service.reviewList();
		model.addAttribute("reviewlist", list);
		return "Admin_Review_List";
	}
	
	@RequestMapping("/Acheckcommentwrite.do")
	public String Acheckcommentwrite(@RequestParam("fidList") String[] fidArray, @RequestParam("pidList") String[] pidArray,@RequestParam("content") String[] contents, Model model) throws Exception{
		for (int i = 0; i < fidArray.length; i++) {
		int fid = Integer.parseInt(fidArray[i].trim());
		System.out.println(fid);
		int pid = Integer.parseInt(pidArray[i].trim());
		String ftitle = contents[i].trim();
		System.out.println(ftitle);
		System.out.println(pid);
		service.checkcommentAction(pid, ftitle, fid);
	}
		return "redirect:AReviewList.do";
	}
	
	
}
