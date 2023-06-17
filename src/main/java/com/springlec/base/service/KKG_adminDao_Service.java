package com.springlec.base.service;

import java.sql.Timestamp;
import java.util.List;

import com.springlec.base.model.AdminExtra_Dto_kkg;

public interface KKG_adminDao_Service {

	
	public List<AdminExtra_Dto_kkg> dailyGraph(Timestamp startday , Timestamp endday) throws Exception;
	
	
	
	
}
