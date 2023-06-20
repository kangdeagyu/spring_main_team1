package com.springlec.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.KJJBasketDao;

@Service
public class KJJBasketDaoServiceImpl implements KJJBasketDaoService {

	@Autowired
	KJJBasketDao dao;
	
	@Override
	public void BasketDao(int pid, String cid, int bqty) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(pid);
		System.out.println(cid);
		System.out.println(bqty);
		dao.BasketDao(pid, cid, bqty);
	}

}
