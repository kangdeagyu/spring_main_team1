package com.springlec.base.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.AdminExtra_Dto_kkg;
import com.springlec.base.service.KKG_adminDao_Service;
import com.springlec.base.service.KKG_extraService;
import com.springlec.base.service.KKG_productDao_Service_Impl;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class KKG_controller {
	
	@Autowired
	KKG_adminDao_Service service ;
	@Autowired
	KKG_extraService exService;
	@Autowired
	KKG_productDao_Service_Impl proService;
	
	@RequestMapping("/adminHome")
	public String list(HttpServletRequest request, Model model) throws Exception {
		
		List<Timestamp> initTS = exService.initTimeStamp();
		List<Date> dateList = exService.DateList(initTS.get(0),initTS.get(1));
		List<String> dateListStr= exService.dateListStr(dateList);
		List<AdminExtra_Dto_kkg> ddrs = service.dailyGraph(initTS.get(0), initTS.get(1));
		List<Integer> saleList = exService.dailySaleList(dateList, ddrs);
		List<Integer> orderList = exService.dailyOrderList(dateList, ddrs);
		
	
		
		model.addAttribute("dailyDate", dateListStr);
		model.addAttribute("dailySale", saleList);
		model.addAttribute("dailyOrder", orderList);
//		
//		
		List<Timestamp> initTS_mon = exService.initMonthTimestamp();
		List<String> monthList = exService.getYearMonthList(initTS_mon.get(0), initTS_mon.get(1));
		List<String> monthListStr = exService.monthTostring(monthList);
		List<AdminExtra_Dto_kkg> mdrs =service.monthlyGraph(initTS_mon.get(0), initTS_mon.get(1));
		List<Integer> monthSaleList = exService.getMonthlySaleList(monthList, mdrs);
		List<Integer> monthOrderList = exService.getMonthlyOrderList(monthList, mdrs);
		
		model.addAttribute("MonthlyMonth", monthListStr);
		model.addAttribute("monthlyOrder", monthOrderList);
		model.addAttribute("monthlySale", monthSaleList);
		
		
		List<AdminExtra_Dto_kkg> DNrs = service.dailyNSGraph(initTS_mon.get(0), initTS_mon.get(1));
		List<Integer> dailyNSList = exService.getDailySaleList(dateList, DNrs);
		
		model.addAttribute("dailyNS", dailyNSList);
		
		
		List<AdminExtra_Dto_kkg> stocks = proService.getOutStocks();
		
		
	
		model.addAttribute("OutofStocks", stocks);
		
		
		return "adminHome";
	}
	
	

}

/* 
        // 가져온 데이터들 request 에 셋팅하기
        
        //일별데이터
        request.setAttribute("dailyDate", dateListStr);
        request.setAttribute("dailySale", saleList);
        request.setAttribute("dailyOrder", orderList);

        //월별데이터
        request.setAttribute("monthlyMonth", monthListStr);
        request.setAttribute("monthlyOrder", monthOrderList);
        request.setAttribute("monthlySale", monthSaleList);
        
        //신규가입자 daily
        request.setAttribute("dailyNS", dailyNSList);
        
        request.setAttribute("OutofStocks", stocks);*
 
 */
