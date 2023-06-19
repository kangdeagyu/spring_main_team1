package com.springlec.base.dao;

import org.apache.ibatis.session.SqlSession;

public class KOrderDaoImpl implements KOrderDao {
	
	SqlSession sqlSession;
	public static String nameSpace = "com.springlec.base.dao.KOrderDao";
	
	// 상품 구매
	@Override
	public void orderProduct(String cid, int pid, int qty, int price, String postnum, String address1,
			String addess2, String memo, String paytype) {
		// TODO Auto-generated method stub
		sqlSession.insert(nameSpace + ".orderProduct");
	}
	// 장바구니 삭제
	@Override
	public void cartDeleteProduct(int pid) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace + ".cartDeleteProduct");
	}
	
	// 상품 재고량 변경
	@Override
	public void prodcutQtyModify(int pid, int qty) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace + ".prodcutQtyModify");
	}
	
	

}
