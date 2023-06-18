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
		
		
		
		// 골라쓸 날짜 데이터들 미리 만들어 두기 
		// 일일날짜 리스트
		List<Timestamp> initTS = exService.initTimeStamp();  					// 최근 2주일 날짜를 뽑기위한 14일전 날짜와 오늘 날짜로 이루어진 리스트
		List<Date> dateList = exService.DateList(initTS.get(0),initTS.get(1)); 	// 두개 날짜 사이의 모든 날짜를 저장한 리스
		List<String> dateListStr= exService.dateListStr(dateList);				// JSP로 보내서 chart.js에 주려면 String 형식이 사고 안나고 좋음. 이것을 위한 문자열리스트 형식의 날짜리스트
		
		//월날짜 리스트
		List<Timestamp> initTS_mon = exService.initMonthTimestamp();							// 오늘이 속한 달과, 12개월전의 날짜로 이루어진 리스트. 
		List<String> monthList = exService.YearMonthList(initTS_mon.get(0), initTS_mon.get(1)); // 그 사이 모든 달이 들어가있는 월리스트
		List<String> monthListStr = exService.monthTostring(monthList);							// 위의 월리스트를 그냥보내면 자꾸 문제 발생해서, ' ' 붙인 형태의 새로운 월목록리스트.
		
		
		//일별 차트 그리기 위한 데이터 셋팅하기
		List<AdminExtra_Dto_kkg> ddrs = service.dailyGraph(initTS.get(0), initTS.get(1));		//sql에서 일별 매출/ 주문건수 검색해옴
		List<Integer> saleList = exService.dailySaleList(dateList, ddrs);						//JSP로 보내기전에 LIST 형식으로 매출 데이터 저장함. 그래프에 넣을떄 편하기 위함.
		List<Integer> orderList = exService.dailyOrderList(dateList, ddrs);						//JSP로 보내기 전에 LIST 형식으로 주문건수 데이터 저장함. 그래프에 넣을떄 편하기위함.
		model.addAttribute("dailyDate", dateListStr);
		model.addAttribute("dailySale", saleList);
		model.addAttribute("dailyOrder", orderList);
		
		//월별 차트 그리기 위한 데이터 셋팅하기. (상세설명은 일별 데이터와 유사하기에 생략.)
		List<AdminExtra_Dto_kkg> mdrs =service.monthlyGraph(initTS_mon.get(0), initTS_mon.get(1));
		List<Integer> monthSaleList = exService.MonthlySaleList(monthList, mdrs);
		List<Integer> monthOrderList = exService.MonthlyOrderList(monthList, mdrs);
		model.addAttribute("monthlyMonth", monthListStr);
		model.addAttribute("monthlyOrder", monthOrderList);
		model.addAttribute("monthlySale", monthSaleList);
		
		
		//신규 가입자수를 그리기 위한 데이터 셋팅하기
		List<AdminExtra_Dto_kkg> DNrs = service.dailyNSGraph(initTS.get(0), initTS.get(1));
		List<Integer> dailyNSList = exService.DailyNSList(dateList, DNrs);
		model.addAttribute("dailyNS", dailyNSList);
		
		//제고 부족한 상품들을 보기 위한 데이터 셋팅하기
		List<AdminExtra_Dto_kkg> stocks = proService.getOutStocks();
		model.addAttribute("OutofStocks", stocks);
		
		
		return "adminHome";
	}
	
	

}


