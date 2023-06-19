package com.springlec.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.KOrderDao;

@Service
public class KOrderDaoServiceImpl implements KOrderDaoService {

	@Autowired
	KOrderDao dao;
	
	// 상품구매
	@Override
	public void orderProduct(String cid, String[] pid, String[] qty, String[] price, String postnum, String address1,
			String addess2, String memo, String paytype) throws Exception {
		// TODO Auto-generated method stub
		for (int i = 0; i <pid.length; i++) {
			dao.orderProduct(cid, pid, qty, price, postnum, address1, addess2, memo, paytype);
		}
	}

}
