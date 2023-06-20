package com.springlec.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.KJJPurchaseNowDao;

@Service
public class KJJPurchaseNowDaoServiceImpl implements KJJPurchaseNowDaoService {

	@Autowired
	KJJPurchaseNowDao dao;

	@Override
	public void purchase(String cid, int pid, int oqty, int oprice, String opostnum, String oaddress1, String oaddress2,
			String omemo, String opaytype) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(cid);
		System.out.println(pid);
		System.out.println(oqty);
		System.out.println(oprice);
		System.out.println(opostnum);
		System.out.println(oaddress1);
		System.out.println(oaddress2);
		System.out.println(omemo);
		System.out.println(opaytype);
		dao.purchase(cid, pid, oqty, oprice, opostnum, oaddress1, oaddress2, omemo, opaytype);
	}
	

}
