package com.springlec.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springlec.base.model.KAdminDto;
import com.springlec.base.model.KUserDto;
import com.springlec.base.service.KUserDaoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class KUserController {

	@Autowired
	KUserDaoService service;
	
	// 로그인 체크 유저, 관리자
	@RequestMapping("/loginCheck")
	@ResponseBody
	public String userChecked(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession(true);
		String cid = request.getParameter("cid");
		String cpassword = request.getParameter("cpassword");

		String result = "error";
		
		if(cid.startsWith("admin")) {
			KAdminDto dto  = service.adminCheck(cid, cpassword);
			if(dto != null) {
				String adeletedate = dto.getAdeletedate();
				
				if(adeletedate != null) {
					result = "mdraw";
				}else {
					result = "admin";
				}
			}
		}else {
			KUserDto dto = service.userCheck(cid, cpassword);
			if(dto != null) {
				String cname = dto.getCname();
				String cdeletedate = dto.getCdeletedate();
				
				if(cdeletedate != null) {
					result = "mdraw";
				}else {
					result = cname;
					session.setAttribute("cid", cid);
					session.setAttribute("name", result);	
				}
			}
		}
		
		return result;
		
	}
	
	// 회원가입 창
	@RequestMapping("/joinView")
	public String joinView() throws Exception{
		return "KJoin";
	}
	
	// 이메일 중복 체크
	@RequestMapping("/emailCheck")
	@ResponseBody
	public int emailCheck(HttpServletRequest request) throws Exception{
		int result = service.emailCheck(request.getParameter("email"));
		return result;
	}
	
	// 회원가입
	@RequestMapping("/joinUser")
	@ResponseBody
	public int joinUser(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");
		String cid = request.getParameter("email");
		String cpassword = request.getParameter("password");
		String cname = request.getParameter("name");
		String cphone = request.getParameter("phone");
		String cbirth = request.getParameter("cbirth");
		String cgender = request.getParameter("genderInputs");
		String cpostnum = request.getParameter("cpostnum");
		String caddress1 = request.getParameter("caddress1");
		String caddress2 = request.getParameter("caddress2");
		int gender = 0;
		
		if(cgender.equals("male")) {
			gender = 1;
		}else {
			gender = 0;
		}

		int result = service.joinUser(cid, cpassword, cname, cphone, cbirth, gender, cpostnum, caddress1, caddress2);
	    return result;
		
	}
	// 카카오 로그인
	@RequestMapping("/kakaoLogin")
	@ResponseBody
	public String kakaoCheck(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession(true);
		String result = service.kakaoLogin(request.getParameter("cid"));
		String accessToken = request.getParameter("accessToken");
		
		if(result.equals("success")) {
			session.setAttribute("Token", accessToken);
			session.setAttribute("cid", request.getParameter("cid"));
			session.setAttribute("name", request.getParameter("cname"));	
		}else if(result.equals("join")) {
    		session.setAttribute("jid", request.getParameter("cid"));
    		session.setAttribute("jname", request.getParameter("cname"));
		}
		
		return result;
	}
	
	// 아이디 찾기
	@RequestMapping("/pindIdview")
	public String pindIdview(HttpServletRequest request, Model model) throws Exception{
		String result = service.findIdCheck(request.getParameter("cname"), request.getParameter("cphone"));
		model.addAttribute("id", result);
		
		return "KFindIdview";
	}
	
	// 비밀번호 찾기
	@RequestMapping("/pindPwView")
	public String pindPwView(HttpServletRequest request, Model model) throws Exception{
		String result = service.findPwCheck(request.getParameter("cid"), request.getParameter("cname"));
		model.addAttribute("pw", result);
		
		return "KFindPwview";
	}
	// 마이 페이지
	@RequestMapping("KMypageView")
	public String KMypageView(HttpServletRequest request, Model model) throws Exception{
		HttpSession session = request.getSession(true);
		List<KUserDto> userList = service.userList((String)session.getAttribute("cid"));
		
		model.addAttribute("list", userList);
		return "KMypage";
	}
	
	// 회원정보 수정
	@RequestMapping("/userModify")
	@ResponseBody
	public int userUpdate(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");
		String cid = request.getParameter("email");
		String cpassword = request.getParameter("password");
		String cname = request.getParameter("name");
		String cphone = request.getParameter("phone");
		String cbirth = request.getParameter("cbirth");
		String cgender = request.getParameter("genderInputs");
		String cpostnum = request.getParameter("cpostnum");
		String caddress1 = request.getParameter("caddress1");
		String caddress2 = request.getParameter("caddress2");
		int gender = 0;
		
		if(cgender.equals("male")) {
			gender = 1;
		}else {
			gender = 0;
		}

		int result = service.userUpdate(cid, cpassword, cname, cphone, cbirth, gender, cpostnum, caddress1, caddress2);
	    return result;
		
	}
	
	// 비밀번호 변경
	@RequestMapping("/pwChange")
	@ResponseBody
	public int pwChange(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession(true);
		String cid = (String)session.getAttribute("cid");
		String password = request.getParameter("password");
		String newpassword = request.getParameter("newpassword");
		
		int result = service.userPwChange(cid, password, newpassword);
		return result;
	}
	
	// 회원탈퇴
	@RequestMapping("/userDraw")
	@ResponseBody
	public void userDraw(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession(true);
		String cid = (String)session.getAttribute("cid");

		service.userDraw(cid);

	}	
	
	
	
	
} // end

