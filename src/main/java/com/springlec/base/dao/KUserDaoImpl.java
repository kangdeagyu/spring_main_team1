package com.springlec.base.dao;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.KUserDto;

public class KUserDaoImpl implements KUserDao {
	
	SqlSession sqlSession;
	public static String nameSpace = "com.springlec.base.dao.KUserDao";

	@Override
	public KUserDto userCheck(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".userCheck");
	}

}
