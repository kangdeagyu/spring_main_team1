package com.springlec.base.dao;

public interface KJJPurchaseNowDao {

	//상품 구매 후 데이터 베이스 저장까지
	public void purchase(String cid, int pid, int oqty, int oprice, String opostnum, String oaddress1,
			String oaddress2, String omemo, String opaytype) throws Exception;
}
