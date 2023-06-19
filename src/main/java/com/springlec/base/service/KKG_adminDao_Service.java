package com.springlec.base.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;

import com.springlec.base.model.AdminExtra_Dto_kkg;

public interface KKG_adminDao_Service {

	
	public List<AdminExtra_Dto_kkg> dailyGraph(Timestamp startday , Timestamp endday) throws Exception;
	public List<AdminExtra_Dto_kkg> monthlyGraph(Timestamp startday , Timestamp endday) throws Exception;
	public List<AdminExtra_Dto_kkg> dailyNSGraph(Timestamp startday , Timestamp endday) throws Exception;
	public List<AdminExtra_Dto_kkg> categoryChart(Timestamp startday, Timestamp endday) throws Exception;
	public List<AdminExtra_Dto_kkg> genderChart(Timestamp startday, Timestamp endday) throws Exception;
	public List<AdminExtra_Dto_kkg> maxOrdersChart(Timestamp startday, Timestamp endday) throws Exception;
	public List<AdminExtra_Dto_kkg> maxSalesChart(Timestamp startday, Timestamp endday)throws Exception;
	
	
	
	
}
