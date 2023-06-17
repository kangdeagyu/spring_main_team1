package com.springlec.base.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.springlec.base.model.AdminExtra_Dto_kkg;

public interface KKG_extraService {
	
	List<Timestamp> initTimeStamp();
	public List<Date> DateList(Timestamp startday, Timestamp endday) throws Exception;
	public List<String> dateListStr(List<Date> dateList) throws Exception;
	List<Integer> dailySaleList(List<Date> dateList, List<AdminExtra_Dto_kkg> ddrs) throws Exception;
	List<Integer> dailyOrderList(List<Date> dateList, List<AdminExtra_Dto_kkg> ddrs) throws Exception;
	
	
	
	
	
}
