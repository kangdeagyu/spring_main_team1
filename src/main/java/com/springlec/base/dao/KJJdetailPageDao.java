package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.KJJdetailPageDto;

public interface KJJdetailPageDao {

	public List<KJJdetailPageDto> listKJJdetailPageDao(int pid) throws Exception;
	
}
