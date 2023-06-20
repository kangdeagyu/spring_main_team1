package com.springlec.base.service;

import java.util.List;

import com.springlec.base.model.KJJpurchaseDto;

public interface KJJpurchaseDaoService {


	public List<KJJpurchaseDto> product(int pid) throws Exception;
	public List<KJJpurchaseDto> customer(String cid) throws Exception;

	
}
