package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.KKG_productDao;
import com.springlec.base.model.AdminExtra_Dto_kkg;

@Service
public class KKG_productDao_Service_Impl implements KKG_productDao_Service {

	@Autowired
	KKG_productDao dao;
	
	
	
	public List<AdminExtra_Dto_kkg> getOutStocks() throws Exception{
		
		return dao.getOutStocks();
	}

}
