package com.springlec.base.service;

public interface KJJPurchaseNowDaoService {

	public void PurchaseNowDao(String cid, int pid, int qty, int price, String postnum, String address1, String address2, String memo, String payment) throws Exception ;
	public void prodcutQtyModify(int pid, int qty) throws Exception;
}
