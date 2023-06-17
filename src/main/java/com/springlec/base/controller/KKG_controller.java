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

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class KKG_controller {
	
	@Autowired
	KKG_adminDao_Service service ;
	@Autowired
	KKG_extraService exService;
	
	@RequestMapping("/adminHome")
	public String list(HttpServletRequest request, Model model) throws Exception {
		
		
		List<Timestamp> initTS = exService.initTimeStamp();
		
System.out.println("initTS 실행 확인 : " + initTS.get(0) + initTS.get(1));
		
		List<Date> dateList = exService.DateList(initTS.get(0),initTS.get(1));
		
System.out.println("dateList 제대로 받아왔을까? 이 위에 확인하자.");
		
		List<String> dateListStr= exService.dateListStr(dateList);
		
System.out.println("dateList 가 문제 없으면 DateListStr 문제도 없을거고 여기서부터가 문제임. dailyGraph");
System.out.println("들어가는 두가지 TimeStamp 값 initTS 확인 : " + initTS.get(0) +" 그리고 "+ initTS.get(1));

	
		List<AdminExtra_Dto_kkg> ddrs = service.dailyGraph(initTS.get(0), initTS.get(1));
		List<Integer> saleList = exService.dailySaleList(dateList, ddrs);
		List<Integer> orderList = exService.dailyOrderList(dateList, ddrs);
		
	
		
		model.addAttribute("dailyDate", dateListStr);
		model.addAttribute("dailySale", saleList);
		model.addAttribute("dailyOrder", orderList);
//		
//		
//		model.addAttribute("MonthlyMonth", monthListStr);
//		model.addAttribute("monthlyOrder", monthOrderList);
//		model.addAttribute("monthlySale", monthSaleList);
//		
//		
//		model.addAttribute("dailyNS", dailyNSList);
//		
//		
//		model.addAttribute("OutofStocks", stocks);
//		
		
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
