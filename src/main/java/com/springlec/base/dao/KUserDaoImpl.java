package com.springlec.base.dao;

import org.apache.ibatis.session.SqlSession;

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

	// 회원가입 이메일 체크
	@Override
	public int emailCheck(String cid) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(cid);
		return sqlSession.selectOne(nameSpace + ".emailCheck");
	}

}
