package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.Kms_Ordering_Dto;

public interface Kms_Ordering_Dao {
	
	public List<Kms_Ordering_Dto> orderinglist(String cid) throws Exception;
	public void orderRefund(int oid) throws Exception;
}
