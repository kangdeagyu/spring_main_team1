package com.springlec.base.dao;

import java.sql.Timestamp;
import java.util.List;

import com.springlec.base.model.AdminExtra_Dto_kkg;

public interface ChartDao_kkg {

	
	public List<AdminExtra_Dto_kkg> dailyGraph(Timestamp startday, Timestamp endday) throws Exception;
	
	
}
