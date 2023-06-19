package com.springlec.base.dao;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.springlec.base.model.AdminExtra_Dto_kkg;

public interface ChartDao_kkg {

	
	List<AdminExtra_Dto_kkg> maxOrders = null;
	public List<AdminExtra_Dto_kkg> dailyGraph(@Param("startday") Timestamp startday, @Param("endday")Timestamp endday) throws Exception;
	public List<AdminExtra_Dto_kkg> monthlyGraph(@Param("startday") Timestamp startday, @Param("endday")Timestamp endday) throws Exception;
	public List<AdminExtra_Dto_kkg> dailyNSGraph(@Param("startday") Timestamp startday, @Param("endday")Timestamp endday) throws Exception;
	public List<AdminExtra_Dto_kkg> categoryChart(@Param("startday") Timestamp startday, @Param("endday")Timestamp endday) throws Exception;
	public List<AdminExtra_Dto_kkg> genderChart(@Param("startday") Timestamp startday, @Param("endday")Timestamp endday) throws Exception;
	public List<AdminExtra_Dto_kkg> maxOrders(@Param("startday") Timestamp startday, @Param("endday")Timestamp endday) throws Exception;
	public List<AdminExtra_Dto_kkg> maxSales(@Param("startday") Timestamp startday, @Param("endday")Timestamp endday)throws Exception;
}
