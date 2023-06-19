package com.springlec.base.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.KKG_OrderDao;
import com.springlec.base.model.AdminExtra_Dto_kkg;

@Service
public class KKG_OrderDao_Service_Impl implements KKG_OrderDao_Service {

	
	@Autowired
	KKG_OrderDao dao;

	@Override
	public List<AdminExtra_Dto_kkg> getOrderlist_Default(String cid, Timestamp startday, Timestamp endday) throws Exception {
		// TODO Auto-generated method stub
		return dao.getOrderList_Default(cid,startday,endday);
	}

	@Override
	public List<AdminExtra_Dto_kkg> getOrderlist_Hope(String cid, Timestamp startday, Timestamp endday) throws Exception {
		// TODO Auto-generated method stub
		return dao.getOrderList_Hope(cid, startday, endday);
	}


	
	
	
	
}
