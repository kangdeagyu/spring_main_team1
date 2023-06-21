package com.springlec.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.KJJPurchaseNowDao;

@Service
public class KJJPurchaseNowDaoServiceImpl implements KJJPurchaseNowDaoService {

	@Autowired
	KJJPurchaseNowDao dao;


	@Override
	public void PurchaseNowDao(String cid, int pid, int qty, int price, String postnum, String address1,
			String address2, String memo, String payment) throws Exception {
		// TODO Auto-generated method stub
		dao.PurchaseNowDao(cid, pid, qty, price, postnum, address1, address2, memo, payment);
		
	}


	@Override
	public void prodcutQtyModify(int pid, int qty) throws Exception {
		// TODO Auto-generated method stub
		dao.prodcutQtyModify(pid, qty);
	}

}
