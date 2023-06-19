package com.springlec.base.service;

import java.util.List;

import com.springlec.base.model.AdminExtra_Dto_kkg;

public interface KKG_UserDao_Service {

	List<AdminExtra_Dto_kkg> getUserList(int pageNum) throws Exception;

	List<AdminExtra_Dto_kkg> getUserCount() throws Exception;

}
