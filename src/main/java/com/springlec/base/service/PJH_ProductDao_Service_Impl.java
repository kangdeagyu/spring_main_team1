package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.PJH_ProductDao;
import com.springlec.base.model.PJH_ProductDto;
@Service
public class PJH_ProductDao_Service_Impl implements PJH_ProductDao_Service {
	
	@Autowired
	PJH_ProductDao dao;
	
	
	@Override
	public List<PJH_ProductDto> productList() throws Exception {
		// TODO Auto-generated method stub
		return dao.productList();
	}


	@Override
	public List<PJH_ProductDto> search1(String list, String query) throws Exception {
		// TODO Auto-generated method stub
		query = '%'+query+'%';
		return dao.search1(list, query);
	}

}
