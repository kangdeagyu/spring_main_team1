package com.springlec.base.dao;

public interface KJJPurchaseNowDao {

	//상품 구매 후 데이터 베이스 저장까지
	public void PurchaseNowDao(String cid, int pid, int qty, int price, String postnum, String address1, String address2, String memo, String payment) throws Exception ;
	
	public void prodcutQtyModify(int pid, int qty) throws Exception;
}
