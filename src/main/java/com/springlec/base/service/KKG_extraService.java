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
	List<Timestamp> initMonthTimestamp() throws Exception;
	List<String> YearMonthList(Timestamp startday,Timestamp  endday) throws Exception;
	List<String> monthTostring(List<String> getYearMonthList) throws Exception;
	List<Integer> MonthlySaleList (List<String> monthListStr, List<AdminExtra_Dto_kkg> mdrs) throws Exception;
	List<Integer> MonthlyOrderList (List<String> monthListStr, List<AdminExtra_Dto_kkg> mdrs) throws Exception;
	List<Integer> DailyNSList (List<Date> dateList, List<AdminExtra_Dto_kkg> ddrs) throws Exception;
	
	
	
}
