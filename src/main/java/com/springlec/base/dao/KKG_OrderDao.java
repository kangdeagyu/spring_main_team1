package com.springlec.base.dao;

import java.sql.Timestamp;
import java.util.List;

import com.springlec.base.model.AdminExtra_Dto_kkg;

public interface KKG_OrderDao {

	List<AdminExtra_Dto_kkg> getOrderList_Default(String cid, Timestamp startday, Timestamp endday) throws Exception;

	List<AdminExtra_Dto_kkg> getOrderList_Hope(String cid, Timestamp startday, Timestamp endday) throws Exception;
	
}
