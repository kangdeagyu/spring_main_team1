package com.springlec.base.dao;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.KAdminDto;
import com.springlec.base.model.KUserDto;

public class KUserDaoImpl implements KUserDao {
	
	SqlSession sqlSession;
	public static String nameSpace = "com.springlec.base.dao.KUserDao";

	// 유저 로그인 체크
	@Override
	public KUserDto userCheck(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".userCheck");
	}
	
	// 관리자 로그인 체크
	@Override
	public KAdminDto adminCheck(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".adminCheck");
	}
	

	// 회원가입 이메일 체크
	@Override
	public int emailCheck(String cid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".emailCheck");
	}

	// 회원가입
	@Override
	public int joinUser(String cid, String cpassword, String cname, String cphone, String cbirthdate, int cgender,
			String cpostnum, String caddress1, String caddress2) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(nameSpace + ".joinUser");
	}

	// 카카오 로그인
	@Override
	public KUserDto kakaoLogin(String cid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".kakaoLogin");
	}



}
