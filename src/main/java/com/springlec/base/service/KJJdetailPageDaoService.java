package com.springlec.base.service;

import java.util.List;

import com.springlec.base.model.KJJdetailPageDto;

public interface KJJdetailPageDaoService {

	public List<KJJdetailPageDto> listKJJdetailPageDao(int pid) throws Exception;
}
