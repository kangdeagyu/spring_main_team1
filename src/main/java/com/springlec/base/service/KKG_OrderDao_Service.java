package com.springlec.base.service;

import java.sql.Timestamp;
import java.util.List;

import com.springlec.base.model.AdminExtra_Dto_kkg;

public interface KKG_OrderDao_Service {

	List<AdminExtra_Dto_kkg> getOrderlist_Default(String cid, Timestamp startday, Timestamp endday)throws Exception;

	List<AdminExtra_Dto_kkg> getOrderlist_Hope(String cid, Timestamp startday, Timestamp endday) throws Exception;

}
