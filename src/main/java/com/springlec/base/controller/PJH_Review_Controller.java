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
	public String Acheckcommentwrite(@RequestParam("fidList") String[] fidArray, @RequestParam("pidList") String[] pidArray,@RequestParam("content") String contents, Model model) throws Exception{
		for (int i = 0; i < fidArray.length; i++) {
		int pid = Integer.parseInt(pidArray[i]);
		int fid = Integer.parseInt(fidArray[i]);
		String ftitle = contents;
		service.checkcommentAction(pid, ftitle, fid);
	}
		return "redirect:AReviewList.do";
	}
	
	
	@RequestMapping("/deleteReview.do")
	public String deleteReview(@RequestParam("fid") String[] selectedItems, Model model) throws Exception{
		for (int i=0; i< selectedItems.length; i++) {
			int fid= Integer.parseInt(selectedItems[i]);
			service.deleteReview(fid);
		}
		return "redirect:AReviewList.do";
	}
	
	@RequestMapping("/AForumView.do")
	public String forumView(@RequestParam("fid") int fid, @RequestParam("ftype") int ftype, Model model) throws Exception {
		List<PJH_ReviewDto> list=service.forumView(fid);
		List<PJH_ReviewDto> list1=service.commentList(fid);
		model.addAttribute("forumView", list);
		model.addAttribute("Clist", list1);
		int listSize= list1.size();
		model.addAttribute("ListSize", listSize);
		model.addAttribute("ftype", ftype);
		model.addAttribute("fid", fid);
		return "AForumView";
	}
	
	
	
	
}
