package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.KKG_UserDao;
import com.springlec.base.model.AdminExtra_Dto_kkg;

@Service
public class KKG_UserDao_Service_Impl implements KKG_UserDao_Service {

	@Autowired
	KKG_UserDao dao;
	
	@Override
	public List<AdminExtra_Dto_kkg> getUserList(int pageNum) throws Exception {
		// TODO Auto-generated method stub
		return dao.getUserList(pageNum);
	}

	@Override
	public List<AdminExtra_Dto_kkg> getUserCount() throws Exception {
		// TODO Auto-generated method stub
		return dao.getUserCount();
	}

}
