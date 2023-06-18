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
		List<String> monthList = exService.YearMonthList(initTS_mon.get(0), initTS_mon.get(1));
		List<String> monthListStr = exService.monthTostring(monthList);
		
System.out.println("시작일 : " + initTS_mon.get(0));
System.out.println("최종일 : " + initTS_mon.get(1));
		List<AdminExtra_Dto_kkg> mdrs =service.monthlyGraph(initTS_mon.get(0), initTS_mon.get(1));
System.out.println("가져온 mdrs의 month : " + mdrs.get(0).getMonth());
System.out.println("*************************************************************");
System.out.println("*************************************************************");
System.out.println("*************************************************************");
System.out.println("*************************************************************");
		List<Integer> monthSaleList = exService.MonthlySaleList(monthList, mdrs);
System.out.println("monthSaleList 의 1번째 값 : " + monthSaleList.get(0));
		
		List<Integer> monthOrderList = exService.MonthlyOrderList(monthList, mdrs);
System.out.println("monthOrderList 의 1번째 값 : " + monthOrderList.get(0));
		
		model.addAttribute("monthlyMonth", monthListStr);
		model.addAttribute("monthlyOrder", monthOrderList);
		model.addAttribute("monthlySale", monthSaleList);
		
		
		List<AdminExtra_Dto_kkg> DNrs = service.dailyNSGraph(initTS.get(0), initTS.get(1));
System.out.println("DNrs 의 날짜 값 : " + DNrs.get(0).getDate());
		List<Integer> dailyNSList = exService.DailyNSList(dateList, DNrs);
		
		
		
		
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
