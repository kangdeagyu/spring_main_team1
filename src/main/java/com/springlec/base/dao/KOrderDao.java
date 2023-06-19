package com.springlec.base.dao;

public interface KOrderDao {

	// 상품 구매
	public void orderProduct(String cid, String[] pid, String[] qty, String[] price, 
			String postnum, String address1, String addess2 , String memo, String paytype) throws Exception;
}
