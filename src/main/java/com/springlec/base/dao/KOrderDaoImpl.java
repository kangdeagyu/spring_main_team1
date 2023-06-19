package com.springlec.base.dao;

import org.apache.ibatis.session.SqlSession;

public class KOrderDaoImpl implements KOrderDao {
	
	SqlSession sqlSession;
	public static String nameSpace = "com.springlec.base.dao.KOrderDao";
	
	// 상품 구매
	@Override
	public void orderProduct(String cid, String[] pid, String[] qty, String[] price, String postnum, String address1,
			String addess2, String memo, String paytype) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(nameSpace + ".orderProduct");
	}

}
