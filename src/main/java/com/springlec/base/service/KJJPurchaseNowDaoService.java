package com.springlec.base.service;

public interface KJJPurchaseNowDaoService {

	public void purchase(String cid, int pid, int oqty, int oprice, String opostnum, String oaddress1,
			String oaddress2, String omemo, String opaytype) throws Exception;
}
