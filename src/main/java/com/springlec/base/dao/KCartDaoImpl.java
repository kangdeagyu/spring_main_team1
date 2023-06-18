package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.KCartDto;

public class KCartDaoImpl implements KCartDao {

	SqlSession sqlSession;
	public static String nameSpace = "com.springlec.base.dao.KCartDao";
	
	@Override
	public List<KCartDto> userCart(String cid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".userCart");
	}

}
