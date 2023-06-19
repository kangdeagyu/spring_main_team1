package com.springlec.base.service;

import java.util.List;

import com.springlec.base.model.Kms_Ordering_Dto;

public interface Kms_Ordering_Service {
	public List<Kms_Ordering_Dto> orderinglist(int cid) throws Exception;
	public void orderRefund(int oid) throws Exception;
}
