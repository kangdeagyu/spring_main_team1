package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.Kms_Forum_Dto;

public class Kms_Forum_DaoImpl implements Kms_Forum_Dao {

	SqlSession sqlSession;
	public String nameSpace = "com.springlec.base.dao.Kms_Forum_Dao";
	@Override
	public List<Kms_Forum_Dto> list(int ftype) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".list");
	}
	
}
