package com.springlec.base.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.ChartDao_kkg;
import com.springlec.base.model.AdminExtra_Dto_kkg;

@Service
public class KKG_adminDao_Service_Impl implements KKG_adminDao_Service {

	@Autowired
	ChartDao_kkg dao;

	@Override
	public  List<AdminExtra_Dto_kkg> dailyGraph(Timestamp startday, Timestamp endday) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Service_Impl  들어옴 ");
		System.out.println("Service_Impl startday :  "+startday);
		return dao.dailyGraph(startday, endday);
	}

	@Override
	public List<AdminExtra_Dto_kkg> monthlyGraph(Timestamp startday, Timestamp endday) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("서비스에서 startday : " + startday);
		System.out.println("서비스에서 endday : " + endday);
		return dao.monthlyGraph(startday, endday);
	}

	@Override
	public List<AdminExtra_Dto_kkg> dailyNSGraph(Timestamp startday, Timestamp endday) throws Exception {
		// TODO Auto-generated method stub
		return dao.dailyNSGraph(startday,endday);
	}
	
	

	

	
	
	
}
