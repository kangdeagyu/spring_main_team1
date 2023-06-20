package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.KJJpurchaseDao;
import com.springlec.base.model.KJJpurchaseDto;

@Service
public class KJJpurchaseDaoServiceImpl implements KJJpurchaseDaoService {

	@Autowired
	KJJpurchaseDao dao;


	@Override
	public List<KJJpurchaseDto> product(int pid) throws Exception {
		// TODO Auto-generated method stub
		return dao.product(pid);
	}



	@Override
	public List<KJJpurchaseDto> customer(String cid) throws Exception {
		// TODO Auto-generated method stub
		return dao.customer(cid);
	
	}
}
