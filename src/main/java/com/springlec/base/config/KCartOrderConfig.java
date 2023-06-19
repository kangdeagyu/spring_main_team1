package com.springlec.base.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springlec.base.dao.KCartDao;
import com.springlec.base.model.KCartOrderDto;
import com.springlec.base.service.KCartOrderService;

@Configuration
public class KCartOrderConfig {

	@Autowired
	KCartDao dao;
	
	@Bean
	public KCartOrderService cartOrderService() {
		return new KCartOrderService() {
			
			@Override
			public List<KCartOrderDto> cartOrder(String[] bids) throws Exception {
			    List<KCartOrderDto> list = new ArrayList<KCartOrderDto>(); // 결과 리스트 초기화

			    for (String bid : bids) {
			        String[] bidValues = bid.split(","); // 쉼표로 구분된 값을 분리
			        for (String value : bidValues) {
			            int intBid = Integer.parseInt(value.trim()); 
			            List<KCartOrderDto> result = dao.cartOrder(intBid); // dao.cartOrder 호출하여 결과 받기
			            list.addAll(result); // 결과를 list에 추가
			        }
			    }

			    return list;
			}
		};
	}
}
