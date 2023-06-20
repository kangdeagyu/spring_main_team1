package com.springlec.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springlec.base.model.PJH_ReviewDto;
import com.springlec.base.service.PJH_ReviewDao_Service;

import jakarta.servlet.http.HttpServletRequest;

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
	// 리뷰 목록에서
	// 체크박스를 누른 상태에서 일괄 댓글 달기
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
	
	// 리뷰목록에서
	// 체크박스를 누른 리뷰 삭제하기
	@RequestMapping("/deleteReview.do")
	public String deleteReview(@RequestParam("fid") String[] selectedItems, Model model) throws Exception{
		for (int i=0; i< selectedItems.length; i++) {
			int fid= Integer.parseInt(selectedItems[i]);
			service.deleteReview(fid);
		}
		return "redirect:AReviewList.do";
	}
	
	// 게시판에서 리뷰나 질문 제목 눌러서 상세하게 볼 수 있는 페이지로 이동
	@RequestMapping("/AForumView.do")
	public String forumView(@RequestParam("fid") int fid, @RequestParam("ftype") int ftype, Model model) throws Exception {
		PJH_ReviewDto list=service.forumView(fid);
		List<PJH_ReviewDto> list1=service.commentList(fid);
		model.addAttribute("forumView", list);
		model.addAttribute("Clist", list1);
		int listSize= list1.size();
		System.out.println(listSize);
		model.addAttribute("ListSize", listSize);
		model.addAttribute("ftype", ftype);
		model.addAttribute("fid", fid);
		return "AForumView";
	}
	
	// 질문게시판, 리뷰게시판 열기
	@RequestMapping("/Awritelist.do")
	public String writeList(@RequestParam("ftype") int ftype, Model model) throws Exception {
		List<PJH_ReviewDto> list=service.writeList(ftype);
		List<PJH_ReviewDto> list1=service.noticeList();
		int listSize= list.size();
		model.addAttribute("ftype", ftype);
		model.addAttribute("RList", list);
		model.addAttribute("noticelist", list1);
		model.addAttribute("ListSize", listSize);
		return "pjh_WriteList";
	}
	
	// 게시판에서 공지사항 제목 눌러서 상세하게 볼 수 있는 페이지로 이동
	@RequestMapping("/ANoticeView.do")
	public String noticeView(@RequestParam("nid") int nid, @RequestParam("ftype") int ftype, Model model) throws Exception{
		PJH_ReviewDto list=service.noticeView(nid);
		model.addAttribute("noticeview", list);
		model.addAttribute("nid", nid);
		model.addAttribute("ftype", ftype);
		return "Pjh_notice";
	}
	
	// 공지사항 적는 페이지로 이동하기
	@RequestMapping("/AdminNoticeWrite.do")
	public String noticeWrite(@RequestParam("ftype") int ftype, Model model) {
		model.addAttribute("ftype", ftype);
		return "Admin_QnA_pjh";
	}
	
	// 공지사항 작성 후 업로드
	@RequestMapping("/ANoticeUpload.do")
	public String noticeUpload(@RequestParam("ftype") int ftype, @RequestParam("title") String title, @RequestParam("content") String content, Model model) throws Exception {
		service.noticeUpload(title, content);
		model.addAttribute("ftype", ftype);
		return "redirect:Awritelist.do?ftype=" + ftype;
	}
	// 게시판에서 리뷰나 질문 삭제하기
	@RequestMapping("/deleteRevieworQnA.do")
	public String deleteReiveworQnA(@RequestParam("fid") int fid, @RequestParam("ftype") int ftype, Model model) throws Exception{
		service.deleteReviewOrQNA(fid);
		model.addAttribute("ftype", ftype);
		return "redirect:Awritelist.do?ftype=" + ftype;
	}
	
	// 게시판에서 공지사항 삭제하기
	@RequestMapping("/AdeleteNotice.do")
	public String deleteNotice(@RequestParam("nid") int nid, @RequestParam("ftype") int ftype, Model model) throws Exception{
		service.deleteNotice(nid);
		model.addAttribute("ftype", ftype);
		return "redirect:Awritelist.do?ftype=" + ftype;
	}
	
	// 게시판에서 검색하기
	@RequestMapping("/Aforumsearch.do")
	public String forumsearch(@RequestParam("ftype") int ftype, @RequestParam("content") String content, Model model) throws Exception{
		List<PJH_ReviewDto> list= service.forumsearch(ftype, content);
		List<PJH_ReviewDto> list1=service.noticeList();
		int listSize=list.size();
		model.addAttribute("RList",list);
		model.addAttribute("ftype",ftype);
		model.addAttribute("noticelist", list1);
		model.addAttribute("ListSize", listSize);
		return "pjh_WriteList";
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
	
	
	
	
	
	
	
	
	
	
	
	
}
