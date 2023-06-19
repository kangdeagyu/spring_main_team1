package com.springlec.base.service;

import java.util.List;

import com.springlec.base.model.KCartDto;
import com.springlec.base.model.KCartOrderDto;

public interface KCartDaoService {

	// 유저 장바구니
	public List<KCartDto> userCart(String cid) throws Exception;
	// 장바구니 수량 변경
	public int qtyChange(int pid, int qty) throws Exception;
	// 선택한 상품 삭제
	public int selectionDelete(String[] bid) throws Exception;	
	// 장바구니 -> 구매 페이지
	public List<KCartOrderDto> cartOrder(String[] bids) throws Exception;	
	
}
