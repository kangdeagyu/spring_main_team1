package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.AdminExtra_Dto_kkg;

public interface KKG_UserDao {

	
	public List<AdminExtra_Dto_kkg> getUserList(int pageNum) throws Exception;

	public List<AdminExtra_Dto_kkg> getUserCount() throws Exception;
	
	
	
}
