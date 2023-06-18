package com.springlec.base.service;

import com.springlec.base.model.KUserDto;

public interface KUserDaoService {

	// 유저 로그인 체크
	public String userCheck(String username, String password) throws Exception;
	// 관리자 로그인 체크
	public String adminCheck(String username, String password) throws Exception;
	// 회원가입 이메일 중복체크
	public int emailCheck(String cid) throws Exception;
	// 회원가입
	public int joinUser(String cid, String cpassword, String cname, String cphone, String cbirthdate, int cgender, String cpostnum,
			String caddress1, String caddress2) throws Exception;
	// 유저 카카오 로그인
	public String kakaoLogin(String cid) throws Exception;	
}
