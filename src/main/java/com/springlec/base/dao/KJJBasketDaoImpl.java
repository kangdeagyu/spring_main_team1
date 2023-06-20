package com.springlec.base.dao;

import org.apache.ibatis.session.SqlSession;

public class KJJBasketDaoImpl implements KJJBasketDao {

	SqlSession sqlSession;
	public String nameSpace = "com.springlec.base.dao.KJJBasketDao";
	@Override
	public void BasketDao(int pid, String cid, int bqty) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(nameSpace + ".BasketDao");
	}

}
