package com.springlec.base.service;

import com.springlec.base.model.KUserDto;

public interface KUserDaoService {

	// 유저 로그인 체크
	public String userCheck(String username, String password) throws Exception;
	// 회원가입 이메일 중복체크
	public int emailCheck(String cid) throws Exception;
}
