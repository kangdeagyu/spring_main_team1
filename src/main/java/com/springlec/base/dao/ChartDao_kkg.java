package com.springlec.base.dao;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.springlec.base.model.AdminExtra_Dto_kkg;

public interface ChartDao_kkg {

	
	public List<AdminExtra_Dto_kkg> dailyGraph(@Param("startday") Timestamp startday, @Param("endday")Timestamp endday) throws Exception;
	public List<AdminExtra_Dto_kkg> monthlyGraph(Timestamp startday, Timestamp endday) throws Exception;
	public List<AdminExtra_Dto_kkg> dailyNSGraph(Timestamp startday, Timestamp endday) throws Exception;
}
