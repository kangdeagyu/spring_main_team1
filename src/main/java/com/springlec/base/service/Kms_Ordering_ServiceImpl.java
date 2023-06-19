package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.Kms_Ordering_Dao;
import com.springlec.base.model.Kms_Ordering_Dto;

@Service
public class Kms_Ordering_ServiceImpl implements Kms_Ordering_Service {

	@Autowired
	Kms_Ordering_Dao dao;

	@Override
	public List<Kms_Ordering_Dto> orderinglist(int cid) throws Exception {
		// TODO Auto-generated method stub
		return dao.orderinglist(cid);
	}

	@Override
	public void orderRefund(int oid) throws Exception {
		// TODO Auto-generated method stub
		dao.orderRefund(oid);
	}

	
}
