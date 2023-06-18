package com.springlec.base.dao;

import com.springlec.base.model.KAdminDto;
import com.springlec.base.model.KUserDto;

public interface KUserDao {

	// 유저 로그인 체크
	public KUserDto userCheck(String username, String password) throws Exception;
	// 관리자 로그인 체크
	public KAdminDto adminCheck(String username, String password) throws Exception;
	// 회원가입 이메일 중복체크
	public int emailCheck(String cid) throws Exception;
	// 회원가입
	public int joinUser(String cid, String cpassword, String cname, String cphone, String cbirthdate, int cgender, String cpostnum,
			String caddress1, String caddress2) throws Exception;
	// 유저 카카오 로그인
	public KUserDto kakaoLogin(String cid) throws Exception;
	// 유저 Id 찾기
	public String findIdCheck(String cname, String cphone) throws Exception;
	// 유저 Pw 찾기
	public String findPwCheck(String cid, String cname) throws Exception;
	
}
