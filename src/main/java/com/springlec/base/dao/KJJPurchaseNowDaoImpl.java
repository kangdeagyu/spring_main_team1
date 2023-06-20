package com.springlec.base.dao;

import org.apache.ibatis.session.SqlSession;

public class KJJPurchaseNowDaoImpl implements KJJPurchaseNowDao {


	SqlSession sqlSession;
	public static String nameSpace = "com.springlec.base.dao.KJJPurchaseNowDao";
	@Override
	public void purchase(String cid, int pid, int oqty, int oprice, String opostnum, String oaddress1, String oaddress2,
			String omemo, String opaytype) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(nameSpace + ".purchase");
	}
	

}
