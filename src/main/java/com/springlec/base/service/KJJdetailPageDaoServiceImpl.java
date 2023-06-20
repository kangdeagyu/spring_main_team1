package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.KJJdetailPageDao;
import com.springlec.base.model.KJJdetailPageDto;

@Service
public class KJJdetailPageDaoServiceImpl implements KJJdetailPageDaoService {

	@Autowired
	KJJdetailPageDao dao;

	@Override
	public List<KJJdetailPageDto> listKJJdetailPageDao(int pid) throws Exception {
		// TODO Auto-generated method stub
		return dao.listKJJdetailPageDao(pid);
	}





	

	

}
