package com.springlec.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.Kms_Forum_Dto;
import com.springlec.base.model.Kms_Notice_Dto;
import com.springlec.base.service.Kms_Forum_Service;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class Kms_Forum_Controller {

	
	@Autowired
	Kms_Forum_Service service;
	// 게시판 리스트
	@RequestMapping("/writelist")
	public String writelist(HttpServletRequest request, Model model) throws Exception{
		List<Kms_Notice_Dto> noticeList = service.noticelist();
		model.addAttribute("noticelist",noticeList);
		List<Kms_Forum_Dto> list = service.writelist(Integer.parseInt(request.getParameter("ftype")));
		model.addAttribute("RList",list);
		int listSize = list.size();
		model.addAttribute("ListSize",listSize);
		return "Kms_WriteList";
	}
	// 공지사항 보기
	@RequestMapping("/noticeView")
	public String noticeView(HttpServletRequest request, Model model) throws Exception{
		Kms_Notice_Dto noticeView = service.noticeView(Integer.parseInt(request.getParameter("nid")));
		model.addAttribute("AforumView",noticeView);
		return "Kms_NoticeView";
	}
	// 리뷰 작성
	@RequestMapping("/writeforum")
	public String writeforum(HttpServletRequest request, Model model) throws Exception{
		String page = request.getParameter("f_cid");
		service.writeforum(request.getParameter("f_cid"), Integer.parseInt(request.getParameter("f_pid")), request.getParameter("ftitle"), request.getParameter("fcontent"));
		service.orderingupdate(Integer.parseInt(request.getParameter("oid")));
		return "redirect:orderinglist?cid=" + page;
	}
	// 게시글 정보
	@RequestMapping("/ForumView")
	public String forumview(HttpServletRequest request, Model model) throws Exception{
		Kms_Forum_Dto forumview = service.forumview(Integer.parseInt(request.getParameter("fid")));
		model.addAttribute("forumView",forumview);
		List<Kms_Forum_Dto> commentlist = service.commentlist(Integer.parseInt(request.getParameter("fid")));
		model.addAttribute("Clist",commentlist);
		int listSize = commentlist.size();
		model.addAttribute("ListSize",listSize);
		return "ForumView";
	}
	// 댓글 작성
	@RequestMapping("/commentAction")
	public String commentAction(HttpServletRequest request, Model model) throws Exception{
		int page = Integer.parseInt(request.getParameter("fid"));
		service.commentAction(request.getParameter("f_cid"), Integer.parseInt(request.getParameter("f_pid")), request.getParameter("ftitle"), Integer.parseInt(request.getParameter("fid")));
		return "redirect:ForumView?fid=" + page;
	}
	// 댓글 삭제
	@RequestMapping("/commentDelete")
	public String commentDelete(HttpServletRequest request, Model model) throws Exception{
		int page = Integer.parseInt(request.getParameter("page"));
		service.commentDelete(Integer.parseInt(request.getParameter("fid")));
		return "redirect:/ForumView?fid=" + page;
	}
	// 글 검색
	@RequestMapping("/forumSearch")
	public String forumSearch(HttpServletRequest request, Model model) throws Exception{
		List<Kms_Notice_Dto> noticeList = service.noticelist();
		model.addAttribute("noticelist",noticeList);
		List<Kms_Forum_Dto> searchlist = service.forumSearch(request.getParameter("content"));
		model.addAttribute("RList",searchlist);
		int listSize = searchlist.size();
		model.addAttribute("ListSize",listSize);
		return "Kms_WriteList";
	}
	// QnA 작성
	@RequestMapping("/QnAwrite")
	public String QnAwrite(HttpServletRequest request, Model model) throws Exception{
		int page = Integer.parseInt(request.getParameter("f_pid"));
		service.QnAwrite(request.getParameter("f_cid"), Integer.parseInt(request.getParameter("f_pid")), request.getParameter("ftitle"), request.getParameter("fcontent"));
		return "redirect:detailPage?pid=" + page;
	}
	// 대댓글 작성
	@RequestMapping("/bigCommentWrite")
	public String bigCommentWrite(HttpServletRequest request, Model model) throws Exception {
	    int page = Integer.parseInt(request.getParameter("page"));
	    if ("0".equals(request.getParameter("freforder"))) {
	        service.bigCommentAction5(request.getParameter("f_cid"), Integer.parseInt(request.getParameter("f_pid")), Integer.parseInt(request.getParameter("fref")), Integer.parseInt(request.getParameter("freforder")), Integer.parseInt(request.getParameter("fanswernum")),
	                request.getParameter("ftitle"), Integer.parseInt(request.getParameter("fmotherid")));
	        service.bigCommentAction6(Integer.parseInt(request.getParameter("fid")));
	    } else {
	        Kms_Forum_Dto totalFanswernum = service.bigCommentAction(Integer.parseInt(request.getParameter("fstep")), Integer.parseInt(request.getParameter("freforder")),
	                Integer.parseInt(request.getParameter("fsteporder")));
	        model.addAttribute("totalFanswernum", totalFanswernum);
	        Kms_Forum_Dto fanswernum = service.bigCommentAction1(Integer.parseInt(request.getParameter("fstep")), Integer.parseInt(request.getParameter("fsteporder")),
	                Integer.parseInt(request.getParameter("freforder")));
	        model.addAttribute("fanswernum", fanswernum);
	        
	        int a;
	        if (totalFanswernum != null && fanswernum != null) {
	            a = totalFanswernum.getTotalFanswernum() - fanswernum.getFanswernum();
	        } else {
	            a = 0; // null인 경우 기본값 0 설정
	        }
	        
	        service.bigCommentAction2(Integer.parseInt(request.getParameter("fsteporder")), a, Integer.parseInt(request.getParameter("freforder")), Integer.parseInt(request.getParameter("fref")));
	        service.bigCommentAction3(request.getParameter("f_cid"), Integer.parseInt(request.getParameter("f_pid")), Integer.parseInt(request.getParameter("fref")), Integer.parseInt(request.getParameter("freforder")), Integer.parseInt(request.getParameter("fstep")),
	                Integer.parseInt(request.getParameter("fsteporder")), a, request.getParameter("ftitle"), Integer.parseInt(request.getParameter("fmotherid")));
	        service.bigCommentAction4(Integer.parseInt(request.getParameter("fid")));
	    }
	    return "redirect:ForumView?fid=" + page;
	}
	
		
	
}
