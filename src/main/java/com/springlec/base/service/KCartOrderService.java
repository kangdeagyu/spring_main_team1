package com.springlec.base.service;

import java.util.List;

import com.springlec.base.model.KCartOrderDto;

public interface KCartOrderService {

	// 장바구니 -> 구매 페이지
		public List<KCartOrderDto> cartOrder(String[] bids) throws Exception;	
}
