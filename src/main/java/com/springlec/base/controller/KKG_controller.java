package com.springlec.base.controller;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.AdminExtra_Dto_kkg;
import com.springlec.base.service.KKG_OrderDao_Service;
import com.springlec.base.service.KKG_OrderDao_Service_Impl;
import com.springlec.base.service.KKG_UserDao_Service;
import com.springlec.base.service.KKG_adminDao_Service;
import com.springlec.base.service.KKG_extraService;
import com.springlec.base.service.KKG_productDao_Service;


import jakarta.servlet.http.HttpServletRequest;

@Controller
public class KKG_controller {
	
	@Autowired
	KKG_adminDao_Service service ;
	@Autowired
	KKG_extraService exService;
	@Autowired
	KKG_productDao_Service proService;
	@Autowired
	KKG_UserDao_Service userService;
	@Autowired
	KKG_OrderDao_Service orderSerivce;
	
	 
	@RequestMapping("/adminHome.do")
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
	
	
	@RequestMapping("/AUserlist.do")
	public String AUserlist(HttpServletRequest request, Model model) throws Exception {
		
		
		// page	번호와 start day 및 end day 의 확정.
		// userlist.jsp 를 최초로 오픈할때는 기본값을 입력함.
		// 그 이후로는 열려있던 pagenum 및 startdate/enddate를  param으로 받아서 출력함. (수정된것은 수정된대로 param으로 입력해줌)

		int pageNum = 1;
		Timestamp startday = null;
		Timestamp endday=null;
		
		
		if (request.getParameter("pageNum") == null ) {
			pageNum = 1;
			List<Timestamp> initTS = exService.initTimeStamp();  					// 최근 2주일 날짜를 뽑기위한 14일전 날짜와 오늘 날짜로 이루어진 리스트
			startday = initTS.get(0);
			endday = initTS.get(1);
			
		}else {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
			System.out.println("parameter에 들어간 startDate : " + request.getParameter("startDate"));
			startday = exService.getTimestampFromParameterDate(request.getParameter("startDate"));
			endday = exService.getTimestampFromParameterDate(request.getParameter("endDate"));
			
		}
		
		
		
		// chart에 보여줄 날짜를 List 형식으로 만들어서 보내줌.
		List<Date> dateList = exService.DateList(startday,endday); 	// 두개 날짜 사이의 모든 날짜를 저장한 리스
		List<String> dateListStr= exService.dateListStr(dateList);				// JSP로 보내서 chart.js에 주려면 String 형식이 사고 안나고 좋음. 이것을 위한 문자열리스트 형식의 날짜리스트
		model.addAttribute("dailyDate", dateListStr);
		model.addAttribute("dateList", dateList);
		
		
		
		//sql에서 신규 일별 신규 가입자 수 가져오고, 비어있는 날짜들은 0으로 채워서 INteger 리스트로 가져오기
		List<AdminExtra_Dto_kkg> DNrs = service.dailyNSGraph(startday, endday);
		List<Integer>dailyNSList = exService.DailyNSList(dateList, DNrs); // 

		model.addAttribute("dailyNS", dailyNSList);
		
		
		//회원 목록을 가져오기 위한 작업.
		List<AdminExtra_Dto_kkg> userList = userService.getUserList(pageNum);
		model.addAttribute("userList", userList);

		
		
		//유저목록의 최대페이지 및 전체 유저회원수 가져오기
		List<AdminExtra_Dto_kkg> chnum = userService.getUserCount();
		model.addAttribute("maxPage",chnum.get(0).getMaxpage()); // 최대 페이지수
		model.addAttribute("usernum",chnum.get(0).getCustNum()); // 회원 목록
		

		
		return "adminUserlist";
	}
	
	
	@RequestMapping("/Salemanage.do")
	public String saleManage(HttpServletRequest request, Model model) throws Exception{
				   
				
				// userlist.jsp 를 최초로 오픈할때는 기본값을 입력함.
				// 그 이후로는 열려있던 startdate/enddate를  param으로 받아서 출력함. (수정된것은 수정된대로 param으로 입력해줌)

				Timestamp startday = null;
				Timestamp endday=null;
				
				
				if (request.getParameter("startDate") == null ) {
					List<Timestamp> initTS = exService.initTimeStamp();  					// 최근 2주일 날짜를 뽑기위한 14일전 날짜와 오늘 날짜로 이루어진 리스트
					startday = initTS.get(0);
					endday = initTS.get(1);
					
				}else {
					System.out.println("parameter에 들어간 startDate : " + request.getParameter("startDate"));
					startday = exService.getTimestampFromParameterDate(request.getParameter("startDate"));
					endday = exService.getTimestampFromParameterDate(request.getParameter("endDate"));
					
				}
		
				
				
				
				
				
				List<Date> dateList = exService.DateList(startday,endday); 	// 두개 날짜 사이의 모든 날짜를 저장한 리스
				List<String> dateListStr= exService.dateListStr(dateList);				// JSP로 보내서 chart.js에 주려면 String 형식이 사고 안나고 좋음. 이것을 위한 문자열리스트 형식의 날짜리스트
				model.addAttribute("dateList", dateListStr);
				
				//월날짜 리스트
				List<String> monthList = exService.YearMonthList(startday, endday); // 그 사이 모든 달이 들어가있는 월리스트
				List<String> monthListStr = exService.monthTostring(monthList);		// 위의 월리스트를 그냥보내면 자꾸 문제 발생해서, ' ' 붙인 형태의 새로운 월목록리스트.
				model.addAttribute("monthList", monthListStr);
				
				
				//일별 차트 그리기 위한 데이터 셋팅하기
				List<AdminExtra_Dto_kkg> ddrs = service.dailyGraph(startday,endday);		//sql에서 일별 매출/ 주문건수 검색해옴
				List<Integer> saleList = exService.dailySaleList(dateList, ddrs);						//JSP로 보내기전에 LIST 형식으로 매출 데이터 저장함. 그래프에 넣을떄 편하기 위함.
				List<Integer> orderList = exService.dailyOrderList(dateList, ddrs);						//JSP로 보내기 전에 LIST 형식으로 주문건수 데이터 저장함. 그래프에 넣을떄 편하기위함.
				
				System.out.println("dailySales : "+ saleList);
				System.out.println("dailyOrders : "+ orderList);
				
				model.addAttribute("dateList", dateListStr);
				model.addAttribute("dailySales", saleList);
				model.addAttribute("dailyOrders", orderList);
				
				//월별 차트 그리기 위한 데이터 셋팅하기. (상세설명은 일별 데이터와 유사하기에 생략.)
				List<AdminExtra_Dto_kkg> mdrs =service.monthlyGraph(startday,endday);
				List<Integer> monthSaleList = exService.MonthlySaleList(monthList, mdrs);
				List<Integer> monthOrderList = exService.MonthlyOrderList(monthList, mdrs);
				model.addAttribute("monthList", monthListStr);
				model.addAttribute("monthlyOrders", monthOrderList);
				model.addAttribute("monthlySales", monthSaleList);
				
				
				
				// 카테고리별 매출 비율 그래프 그리기
				List<AdminExtra_Dto_kkg> categoryDtos = service.categoryChart(startday, endday);
				List<String> categoryName = exService.getCategoryName(categoryDtos);
				List<Integer> categoryOrders = exService.getOrders(categoryDtos);
				List<Integer> categorySales = exService.getSales(categoryDtos);
				model.addAttribute("categoryList", categoryName);
				model.addAttribute("categoryOrders", categoryOrders);
				model.addAttribute("categorySales", categorySales);
				
				
				
				// 남녀별 매출/주문량 비율 그래프 그리기
				
				List<AdminExtra_Dto_kkg> genderDtos = service.genderChart(startday,endday);
				List<String> genderName = Arrays.asList("'남'","'여'");
				List<Integer> genderOrders = exService.getOrders(genderDtos);
				List<Integer> genderSales = exService.getSales(genderDtos);
				model.addAttribute("genderList",genderName);
				model.addAttribute("genderOrders",genderOrders);
				model.addAttribute("genderSales",genderSales);
				
				
				//매출 및 판매량 탑5 물품 목록
				List<AdminExtra_Dto_kkg> MaxOrdersDtos = service.maxOrdersChart(startday,endday);
				List<AdminExtra_Dto_kkg> MaxSalesDtos = service.maxSalesChart(startday,endday);
				
				List<String> maxPnameOrders = exService.getPname(MaxOrdersDtos);
				List<Integer> maxOrders = exService.getOrders(MaxOrdersDtos);

				List<String> MaxPnameSales = exService.getPname(MaxSalesDtos);
				List<Integer> maxSales = exService.getSales(MaxSalesDtos);
		
		
				
				model.addAttribute("maxPnameOrders", maxPnameOrders);
				model.addAttribute("maxOrders", maxOrders);
				model.addAttribute("maxPnameSales", MaxPnameSales);
				model.addAttribute("maxSales", maxSales);
				
		
		return "adminSalemanage";
	}
	
	@RequestMapping("/Ordermanage.do")
	public String ordermanage(HttpServletRequest request, Model model) throws Exception{
		
		String cid ;
		Timestamp startday = null;
		Timestamp endday=null;

		
		//최초 오픈할때 날짜 데이터 없을테니 그땐 전체 날짜를 지정해준다.
		if (request.getParameter("startDate") == null ) {
			List<Timestamp> initTS = exService.wholeTimeStamp();  					// 최근 2주일 날짜를 뽑기위한 14일전 날짜와 오늘 날짜로 이루어진 리스트
			startday = initTS.get(0);
			endday = initTS.get(1);
			
		}else {
			startday = exService.getTimestampFromParameterDate(request.getParameter("startDate"));
			endday = exService.getTimestampFromParameterDate(request.getParameter("endDate"));
		}
		
		// 최초 오픈할때는 (cid 가 없을 때는) default 값 지정.
		if(request.getParameter("customerId")==null||request.getParameter("customerId").equals("1")) {		
			cid= "1" ;
			List<AdminExtra_Dto_kkg> dtos = orderSerivce.getOrderlist_Default(cid, startday, endday);
			int ListSize = dtos.size();
			
			model.addAttribute("orderList", dtos);
			model.addAttribute("ListSize", ListSize);
			model.addAttribute("customerId", cid);
			model.addAttribute("startDate", startday);
			model.addAttribute("endDate", endday);
			
			
			
		}else {
			cid = request.getParameter("customerId");
			List<AdminExtra_Dto_kkg> dtos = orderSerivce.getOrderlist_Hope(cid, startday, endday);
			int ListSize = dtos.size();
			
			model.addAttribute("orderList", dtos);
			model.addAttribute("ListSize", ListSize);
			model.addAttribute("customerId", cid);
			model.addAttribute("startDate", startday);
			model.addAttribute("endDate", endday);
			System.out.println("입력된 값들 : " + cid +" : "+ dtos);
			
		}
		
			
		

	
		return "adminOrder";
	}
	
	@RequestMapping("saveOrderList")
	public String saveOrderList(HttpServletRequest request, Model model) throws Exception{
		
		String cid ;
		Timestamp startday = null;
		Timestamp endday=null;

		
		//최초 오픈할때 날짜 데이터 없을테니 그땐 전체 날짜를 지정해준다.
		if (request.getParameter("startDate") == null ) {
			List<Timestamp> initTS = exService.wholeTimeStamp();  					// 최근 2주일 날짜를 뽑기위한 14일전 날짜와 오늘 날짜로 이루어진 리스트
			startday = initTS.get(0);
			endday = initTS.get(1);
			
		}else {
			startday = exService.getTimestampFromParameterDate(request.getParameter("startDate"));
			endday = exService.getTimestampFromParameterDate(request.getParameter("endDate"));
		}
		
		// 최초 오픈할때는 (cid 가 없을 때는) default 값 지정.
		if(request.getParameter("customerId")==null||request.getParameter("customerId").equals("1")) {		
			cid= "1" ;
			List<AdminExtra_Dto_kkg> dtos = orderSerivce.getOrderlist_Default(cid, startday, endday);
			int ListSize = dtos.size();
			
			model.addAttribute("orderList", dtos);
			model.addAttribute("ListSize", ListSize);
			model.addAttribute("customerId", cid);
			model.addAttribute("startDate", startday);
			model.addAttribute("endDate", endday);
			
			
			
		}else {
			cid = request.getParameter("customerId");
			List<AdminExtra_Dto_kkg> dtos = orderSerivce.getOrderlist_Hope(cid, startday, endday);
			int ListSize = dtos.size();
			
			model.addAttribute("orderList", dtos);
			model.addAttribute("ListSize", ListSize);
			model.addAttribute("customerId", cid);
			model.addAttribute("startDate", startday);
			model.addAttribute("endDate", endday);
			System.out.println("입력된 값들 : " + cid +" : "+ dtos);
			
		}
		

	
		return "saveOrderList";
	}
	

}


