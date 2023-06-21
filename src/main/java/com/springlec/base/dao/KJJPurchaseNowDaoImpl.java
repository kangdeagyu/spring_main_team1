package com.springlec.base.dao;

import org.apache.ibatis.session.SqlSession;

public class KJJPurchaseNowDaoImpl implements KJJPurchaseNowDao {


	SqlSession sqlSession;
	public static String nameSpace = "com.springlec.base.dao.KJJPurchaseNowDao";
	@Override
	public void PurchaseNowDao(String cid, int pid, int qty, int price, String postnum, String address1,
			String address2, String memo, String payment) throws Exception {
		// TODO Auto-generated method stub

		sqlSession.insert(nameSpace + ".PurchaseNowDao");
	}
	
	@Override
	public void prodcutQtyModify(int pid, int qty) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace + ".prodcutQtyModify");
		
		
	}
	

}
