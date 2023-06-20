package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.KJJpurchaseDto;

public interface KJJpurchaseDao {

	public List<KJJpurchaseDto> product(int pid) throws Exception;
	public List<KJJpurchaseDto> customer(String cid) throws Exception;
}
