package com.springlec.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.KUserDao;
import com.springlec.base.model.KUserDto;

import jakarta.servlet.http.HttpSession;

@Service
public class KUserDaoServiceImpl implements KUserDaoService {

	@Autowired
	KUserDao dao;
	
	// 회원 체크
	@Override
	public String userCheck(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		KUserDto dto = dao.userCheck(username, password);
		String result = "error";
		
		if(dto != null) {
			String cname = dto.getCname();
			String cdeletedate = dto.getCdeletedate();
			
			if(cdeletedate != null) {
				result = "mdraw";
			}else {
				result = cname;
			}
		}
		
		return result;
	}

	// 이메일 체크
	@Override
	public int emailCheck(String cid) throws Exception {
		// TODO Auto-generated method stub
		int result = dao.emailCheck(cid);
		return result;
	}
	
	// 회원가입
	@Override
	public int joinUser(String cid, String cpassword, String cname, String cphone, String cbirthdate, int cgender,
			String cpostnum, String caddress1, String caddress2) throws Exception {
		// TODO Auto-generated method stub
		int result = dao.joinUser(cid, cpassword, cname, cphone, cbirthdate, cgender, cpostnum, caddress1, caddress2);
		return result;
	}
	
	// 카카오 로그인
	@Override
	public String kakaoLogin(String cid) throws Exception {
		// TODO Auto-generated method stub
		KUserDto dto = dao.kakaoLogin(cid);
		String result = "join";
		
		// 카카오 로그인 체크 작업
		// dto에 값이 없을경우는 체크 안함
		if(dto != null) {
			String kcid = dto.getCid();
			
			if(kcid != null && dto.getCpassword() != null && dto.getCdeletedate() == null) {
				result = "success";
			}else if(kcid != null && dto.getCpassword() != null && dto.getCdeletedate() != null) {
				result = "mdraw";
			}
			
		}
		
		return result;
	}

}
