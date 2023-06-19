package com.springlec.base.config;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springlec.base.model.AdminExtra_Dto_kkg;
import com.springlec.base.service.KKG_extraService;

@Configuration
public class KKG_config {

	int A = 0;
	
	@Bean
	public KKG_extraService extraService() {
		return new KKG_extraService() {

			// 최초 실행시에는 최근 2주간의 날짜를 보여주어야 한다.
			// 오늘을 endday, 14일전을 startday로 만든다.
			@Override
			public List<Timestamp> initTimeStamp(){	
				Date sqlDate = new Date(System.currentTimeMillis());
				Timestamp endday = new Timestamp(sqlDate.getTime());
				Calendar tempday = Calendar.getInstance();
				tempday.setTime(endday);
				tempday.add(Calendar.DAY_OF_MONTH, -14);
				Timestamp startday = new Timestamp(tempday.getTimeInMillis());
				
				return Arrays.asList(startday, endday);
			}
			

			// 두 날짜 사이의 모든 날짜를 List<Date>로 만든다.
			// 만든 이 List<Date>는 DB에서 매출/주문/회원수 등의 자료를 가져와서, 비교할때 쓸 리스트이다.
			// 비교하는 이유는 특정한 날에 해당 데이터가 없으면 ArrrayList <Dto>에서 빠져 있을 것이기 때문이다.

			// DB에 자동적으로 모든 날짜에 모든 해당값에 0을 입력하는 방법도 고려했지만, 코딩 연습을 위해서 기각했다.
			// 또한, 다른 사람들이 해당테이블을 어떻게 쓸지 알 수 없었다.

			@Override
			public List<Date> DateList(Timestamp startday, Timestamp endday) {
				A +=1;
System.out.println("DateList 실행 되었는지확인하기. " + A + "번째 들어옴");
System.out.println("시작일 : "+startday);
System.out.println("마지막 : "+endday);
				
System.out.println("DateList 결과물 : "+getDateList(startday, endday));
				return getDateList(startday, endday); // 하단의 method 01. 참조.
			}

			
			
			
			// JSP 에서 차트 그릴때는 x축에 날짜도 string형식으로 보내야 한다.
			@Override
			public List<String> dateListStr(List<Date> dateList) {
				// TODO Auto-generated method stub

				return getDateListStr(dateList); // 하단의 method 02. 참조.
			}

		
			
			
			// 일별 매출데이터를 List<Integer>로 뽑아낸다. 차트를 그릴때 편하게 하기 위해서.
			// sale 뿐만 아니라, 주문수량, 신규가입수 등의 데이터도 하나로 합쳐서 할 수 있을 것 같다.
			// Dto에 공용으로 쓰는 변수 하나만 추가하면 되겠지. int value 정도의 네이밍으로?
			// 하지만 일단 반복해서 클래스 구성을 눈에 익히고, 연습해보기 위해, 모든 경우를 각각의 method로 만들어서 진행하였다.
			@Override
			public List<Integer> dailySaleList(List<Date> dateList, List<AdminExtra_Dto_kkg> ddrs) throws Exception {
				return getDailySaleList(dateList, ddrs); // 하단은 method 03 참조
			}




			@Override
			public List<Integer> dailyOrderList(List<Date> dateList, List<AdminExtra_Dto_kkg> ddrs) throws Exception {
				// TODO Auto-generated method stub
				
				
				
				return getDailyOrderList(dateList, ddrs);
			}




			@Override
			public List<Timestamp> initMonthTimestamp() throws Exception {
				// TODO Auto-generated method stub
				
				Date sqlDate = new Date(System.currentTimeMillis());
				Timestamp endday = new Timestamp(sqlDate.getTime());
				Calendar tempday = Calendar.getInstance();
				tempday.setTime(endday);
				tempday.set(Calendar.DAY_OF_MONTH, 1);
				tempday.add(Calendar.MONTH, -12);
				Timestamp startday = new Timestamp(tempday.getTimeInMillis());
				
				
				return Arrays.asList(startday, endday) ;
			
				
			}




			@Override
			public List<String> YearMonthList(Timestamp startday, Timestamp endday) throws Exception {
				// TODO Auto-generated method stub
				
				
				
				return getYearMonthList(startday, endday);
			}




			@Override
			public List<String> monthTostring(List<String> getYearMonthList) throws Exception {
				// TODO Auto-generated method stub
				
				List<String> monthListStr = new ArrayList<>();
				
		        for (String month : getYearMonthList) {
		            monthListStr.add("'"+month+"'");
		        }
				
				
				return monthListStr;
			}




			@Override
			public List<Integer> MonthlySaleList(List<String> monthListStr, List<AdminExtra_Dto_kkg> mdrs)
					throws Exception {
				// TODO Auto-generated method stub
				return getMonthlySaleList(monthListStr, mdrs);
			}




			@Override
			public List<Integer> MonthlyOrderList(List<String> monthListStr, List<AdminExtra_Dto_kkg> mdrs)
					throws Exception {
				// TODO Auto-generated method stub
				return getMonthlyOrderList(monthListStr, mdrs);
			}




			@Override
			public List<Integer> DailyNSList(List<Date> dateList, List<AdminExtra_Dto_kkg> DNrs) throws Exception {
				// TODO Auto-generated method stub
				
				
				return getDailySaleList(dateList, DNrs);  //DTO 에 Date / SALE 로 저장하는 방식이 있어서 이렇게 써서 가져옴.
			}


			@Override
			public Timestamp getTimestampFromParameterDate(String date) throws Exception {
				// TODO Auto-generated method stub
				SimpleDateFormat tempFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
				
				return new Timestamp(tempFormat.parse(date + " 00:00:00").getTime());
			}

			@Override
			public Timestamp getTimestampFromParameterDate2(String date) throws Exception {
				// TODO Auto-generated method stub
				SimpleDateFormat tempFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
				
				return new Timestamp(tempFormat.parse(date + " 23:59:59").getTime());
			}
			
			

			@Override
			public List<String> getCategoryName(List<AdminExtra_Dto_kkg> categoryDtos) {
				// TODO Auto-generated method stub
				return CategoryName(categoryDtos);
			}


			@Override
			public List<Integer> getOrders(List<AdminExtra_Dto_kkg> categoryDtos) {
				// TODO Auto-generated method stub
				return gorders(categoryDtos);
			}


			@Override
			public List<Integer> getSales(List<AdminExtra_Dto_kkg> categoryDtos) {
				// TODO Auto-generated method stub
				return gsales(categoryDtos);
			}


			@Override
			public List<String> getPname(List<AdminExtra_Dto_kkg> maxOrdersDtos) {
				// TODO Auto-generated method stub
				return gpname(maxOrdersDtos);
			}


			@Override
			public List<Timestamp> wholeTimeStamp() throws Exception {
				// TODO Auto-generated method stub
				
				
				
				Timestamp startDay = Timestamp.valueOf("1900-01-01 00:00:00");
				Timestamp endDay = Timestamp.valueOf(LocalDate.now().plusDays(1).atStartOfDay());

				
				return Arrays.asList(startDay, endDay);
			}
		};

	}


	
	
	
	
	// ------------------- function -------------------

	// ----------------- method01. DB에서 받은 리스트와 대조할 날짜 리스트 만들기. ----------------

	private static List<Date> getDateList(Timestamp startday, Timestamp endday) {
		List<Date> dateList = new ArrayList<>();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startday);

		while (!calendar.getTime().after(endday)) {
			Date currentDate = new Date(calendar.getTimeInMillis());
			dateList.add(currentDate);
			calendar.add(Calendar.DATE, 1);
		}

		return dateList;
	}

	// ----------------- method02. JSP 로 넘겨줄 List<String> 형태의 날짜 배열 만들기 (차트 그리기용)----------------

	private static List<String> getDateListStr(List<Date> dateList) {
		List<String> dateListStr = new ArrayList<>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd");

		for (Date date : dateList) {
			String dateString = dateFormat.format(date);
			dateListStr.add("'" + dateString + "'");
		}

		return dateListStr;

	}

	// ----------------- method03. JSP로 내보낼 일별 Sale데이터들을 List<integer>로 만들기. DB에서 받아온 내용을 날짜별로 대조해서 없는 날은 0 으로 만들어야함. ----------------

	private List<Integer> getDailySaleList(List<Date> dateList, List<AdminExtra_Dto_kkg> ddrs) {

		List<Integer> saleList = new ArrayList<>();

		// 날짜 별로 판매금액 가져오는 중. / 판매 없는 날은 0넣어야 함.

		// while 문을 돌려서, 매출액 리스트를 채울거임. while 문 조건은 다음과 같음.
		// 실제 기간내 모든 날짜가 담긴 리스트 : dateList 의 길이를 len 으로 지정함.
		// k는 dateList 내 날짜를 탐색할 번호임. 이 번호가 dateList의 길이보다 작아야함.(배열의 시작은 0이기 때문임)
		// j는 DB에서 받아온 Arraylist<dto> 안에 있는 날짜들을 탐색하는 번호임.
		// 판매가 없는 날은 포함되지 않았을 것이기에, 탐색번호를 j,k로 구분하였음.

		int j = 0;
		int k = 0;
		int len = dateList.size(); // 실제 기간내 모든 기간이

		// --------------while문 설명 : while문이 돌아가는 조건은 위에서 이야기하였음.----------------
		// try 문을 쓴 이유는 db에서 가져온 값에 null point exception 이 발생할 것이기 때문임.
		// 최근 몇일간 판매량이 없었다면,혹은 당일 판매량이 아직 없다면 null point exception이 발생할 수 밖에 없음.
		// 따라null point exception 이 발생하면, k값만 늘려서 반복문을 지속하기 위함. (근데 j값 늘려도 상관 없음. 어차피 db
		// 에서 가져온 데이터는 끝일거라서.)
		// try 문 DB 값의 날짜와, real 날짜 리스트의 값을 탐색함.

		// ------ try 안의 if 문 설---------
		// if 문안에서 위에 탐색한 두 날짜가 없으면, saleList에다가 0 을 추가함. ( 해당하는 Real_date에 해당하는 sale 값이
		// 없다는 소리기 때문)
		// DB 값의 날짜는 그대로 두고, real 날짜만 다음 날짜를 탐색해 오기 위해 k에만 1을 더해줌.

		// 위에 탐색한 두 날짜가 같으면 해당하는 db 값의 sale 데이터를 saleList에 추가함.
		// j와 k를 둘다 ++함.
		while (k < len) {

			try {
				// DB에서 가져온 목록에서 오늘 날짜의 날이 있는지 없는지 검증.
				Date DB_date = ddrs.get(j).getDate(); // DB 데이터의 날짜.
				Date Real_date = dateList.get(k); // 실제 있어야 하는 날짜.

				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // 날짜를 문자열로 변환합니다.

				if (dtf.format(DB_date.toLocalDate()).equals(dtf.format(Real_date.toLocalDate()))) {

					saleList.add(ddrs.get(j).getSale()); // 날짜가 있으면

					j++;
					k++;
				}

				else if (DB_date.compareTo(Real_date) > 0) {
					saleList.add(0); // 날짜가 없으면 (같지 않으면) 0 더하기.
					k++;

				} else {
					j++;
				}

			} catch (IndexOutOfBoundsException e) {
				saleList.add(0);
				// j++;
				k++;
			} // outofbound에러 처리 끝.
		} // daily sale을 위한 while 끝

		return saleList;

	} // -------------------------DailySale 저장하기 getDailySaleList
		// 끝-------------------------------------------
	
	
	//----------------method 04. DailyOrder 저장하기 getDailyOrderList
	private List<Integer> getDailyOrderList(List<Date> dateList, List<AdminExtra_Dto_kkg> ddrs){
		
        List<Integer> OrderList = new ArrayList<>();

        // 날짜 별로 판매금액 가져오는 중. / 판매 없는 날은 0넣어야 함.
   
        //while 문을 돌려서, 매출액 리스트를 채울거임. while 문 조건은 다음과 같음.
        //실제 기간내 모든 날짜가 담긴 리스트 : dateList 의 길이를 len 으로 지정함.
        //k는 dateList 내 날짜를 탐색할 번호임. 이 번호가 dateList의 길이보다 작아야함.(배열의 시작은 0이기 때문임)
        //j는 DB에서 받아온 Arraylist<dto> 안에 있는 날짜들을 탐색하는 번호임.
        //판매가 없는 날은 포함되지 않았을 것이기에, 탐색번호를 j,k로 구분하였음.
        
        int j = 0;
        int k = 0;
        int len = dateList.size(); //실제 기간내 모든 기간이 
        
        
        // --------------while문 설명 : while문이 돌아가는 조건은 위에서 이야기하였음.----------------
        // try 문을 쓴 이유는 db에서 가져온 값에 null point exception 이 발생할 것이기 때문임.
        // 최근 몇일간 판매량이 없었다면,혹은 당일 판매량이 아직 없다면 null point exception이 발생할 수 밖에 없음. 
        // 따라null point exception 이 발생하면, k값만 늘려서 반복문을 지속하기 위함. (근데 j값 늘려도 상관 없음. 어차피 db 에서 가져온 데이터는 끝일거라서.)
        // try 문 DB 값의 날짜와, real 날짜 리스트의 값을 탐색함.
        
        // ------ try 안의 if 문 설---------
        // if 문안에서 위에 탐색한 두 날짜가 없으면,  saleList에다가 0 을 추가함. ( 해당하는 Real_date에 해당하는 sale 값이 없다는 소리기 때문)
        // DB 값의 날짜는 그대로 두고, real 날짜만 다음 날짜를 탐색해 오기 위해 k에만 1을 더해줌.
        
        // 위에 탐색한 두 날짜가 같으면 해당하는 db 값의 sale 데이터를 saleList에 추가함.
        // j와 k를 둘다 ++함.
        
		while (k < len) {


			try {
				// DB에서 가져온 목록에서 오늘 날짜의 날이 있는지 없는지 검증.
				Date DB_date = ddrs.get(j).getDate(); // DB 데이터의 날짜.
				Date Real_date = dateList.get(k); // 실제 있어야 하는 날짜.

				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

//날짜를 문자열로 변환합니다.


			if(dtf.format(DB_date.toLocalDate()).equals(dtf.format(Real_date.toLocalDate()))) {
				
				OrderList.add(ddrs.get(j).getCount()); // 날짜가 있으면
				j++;
				k++;
			}

			else if (DB_date.compareTo(Real_date)>0) {
				OrderList.add(0); // 날짜가 없으면 (같지 않으면) 0 더하기.
				k++;
			
			
			} else {
				
				j++;
			}
			} catch (IndexOutOfBoundsException e) {
				OrderList.add(0);
				// j++;
				k++;
			} // outofbound에러 처리 끝.
		} // daily sale을 위한 while 끝
		
		return OrderList;
		
	}  //method04. orderList  
	
	// -------------------------method05. 월별 리스트 만들-------------------------------------------
	
	
	
    public static List<String> getYearMonthList(Timestamp startday, Timestamp endday) {
        List<String> yearMonthList = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startday);
        
        LocalDate startDate = startday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate endDate = endday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        Period period = Period.between(startDate, endDate);
        int numMonths = 1 + period.getYears() * 12 + period.getMonths();
   
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");

        // 현재 월부터 numMonths 개월 전까지 루프
        for (int i = 0; i < numMonths; i++) {
            Date currentDate = new Date(calendar.getTimeInMillis());
            String yearMonth = dateFormat.format(currentDate);
            
            yearMonthList.add(yearMonth);

            calendar.add(Calendar.MONTH, +1); // 이전 월로 이동
        }

        return yearMonthList;
    }
	
	
    // -------------------------method06. monthlySale 저장하기 메소드 시작-------------------------------------------
	
  	private List<Integer> getMonthlySaleList(List<String> monthListStr, List<AdminExtra_Dto_kkg> mdrs){
  		
          List<Integer> saleList = new ArrayList<>();

   
          
          int j = 0;
          int k = 0;
          int len = monthListStr.size(); //실제 기간내 모든 기간이 
          
          

          
  		while (k < len) {

  			try {
  				// DB에서 가져온 목록에서 오늘 날짜의 날이 있는지 없는지 검증.
  				String DB_month = mdrs.get(j).getMonth(); // DB 데이터의 날짜.
  				String Real_month = monthListStr.get(k); // 실제 있어야 하는 날짜.

  				if (!DB_month.equals(Real_month)) {
  					saleList.add(0); // 날짜가 없으면 (같지 않으면) 0 더하기.
  					k++;
  				} else {
  					saleList.add(mdrs.get(j).getSale()); // 날짜가 있으면
  					j++;
  					k++;
  				}
  			} catch (IndexOutOfBoundsException e) {
  				saleList.add(0);
  				// j++;
  				k++;
  			} // outofbound에러 처리 끝.
  		} // daily sale을 위한 while 끝
          
  		
  		
  		return saleList;
        
  		
  		
  		
  	}   // -------------------------monthlySale 저장하기 끝-------------------------------------------
      
  	
      // -------------------------method07. monthlyOrder 저장하기 메소드 시작-------------------------------------------
  	
  	private List<Integer> getMonthlyOrderList(List<String> monthListStr, List<AdminExtra_Dto_kkg> mdrs){
  		
          List<Integer> orderList = new ArrayList<>();

   
          
          int j = 0;
          int k = 0;
          int len = monthListStr.size(); //실제 기간내 모든 기간이 
          
          

          
  		while (k < len) {

  			try {
  				// DB에서 가져온 목록에서 오늘 날짜의 날이 있는지 없는지 검증.
  				String DB_month = mdrs.get(j).getMonth(); // DB 데이터의 날짜.
  				String Real_month = monthListStr.get(k); // 실제 있어야 하는 날짜.

  				if (!DB_month.equals(Real_month)) {
  					orderList.add(0); // 날짜가 없으면 (같지 않으면) 0 더하기.
  					k++;
  				} else {
  					orderList.add(mdrs.get(j).getCount()); // 날짜가 있으면
  					j++;
  					k++;
  				}
  			} catch (IndexOutOfBoundsException e) {
  				orderList.add(0);
  				// j++;
  				k++;
  			} // outofbound에러 처리 끝.
  		} // daily sale을 위한 while 끝
          
  		
  		
  		return orderList;
        
  		
  		
  		
  	}   // -------------------------monthlySale 저장하기 끝-------------------------------------------
	
	// ------------method 08 : 가져온 dto 리스트에서 카테고리 이름만 빼서 배열로 반환하기 -----------
	private List<String> CategoryName(List<AdminExtra_Dto_kkg> dtos) {
		List<String> categoryNames = new ArrayList<>();

		for (int i = 0; i < dtos.size(); i++) {
			categoryNames.add("'"+dtos.get(i).getCategoryName()+"'");

		}

		return categoryNames;

	}// ----------------- method 08 끝

	// ---------------method 09 : 가져온 dto 에서 orders 빼오기.

	private List<Integer> gorders(List<AdminExtra_Dto_kkg> dtos) {
		List<Integer> Orders = new ArrayList<>();

		for (int i = 0; i < dtos.size(); i++) {
			Orders.add(dtos.get(i).getOrders());

		}

		return Orders;

	}// ----------------method 09 끝

	// ---------------method 10 : 가져온 dto 에서 Sales 빼오기.

	private List<Integer> gsales(List<AdminExtra_Dto_kkg> dtos) {
		List<Integer> Sales = new ArrayList<>();

		for (int i = 0; i < dtos.size(); i++) {
			Sales.add(dtos.get(i).getSale());

		}

		return Sales;

	}// ----------------method 10 끝
	
	
	// ------------method 11: 가져온 dto 리스트에서 상품 이름만 빼서 배열로 반환하기 -----------
	private List<String> gpname(List<AdminExtra_Dto_kkg> maxOrdersDtos) {
		List<String> productName = new ArrayList<>();

		for (int i = 0; i < maxOrdersDtos.size(); i++) {
			productName.add("'" + maxOrdersDtos.get(i).getPname() + "'");

		}

		return productName;

	}// ----------------- method 11 끝

} // end game
