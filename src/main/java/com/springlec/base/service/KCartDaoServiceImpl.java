package com.springlec.base.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.KCartDao;
import com.springlec.base.model.KCartDto;
import com.springlec.base.model.KCartOrderDto;

@Service
public class KCartDaoServiceImpl implements KCartDaoService {

	@Autowired
	KCartDao dao;
	
	// 장바구니
	@Override
	public List<KCartDto> userCart(String cid) throws Exception {
		// TODO Auto-generated method stub
		return dao.userCart(cid);
	}

	// 수량 변경
	@Override
	public int qtyChange(int pid, int qty) throws Exception {
		// TODO Auto-generated method stub
		return dao.qtyChange(pid, qty);
	}
	// 선택한 상품 삭제
	@Override
	public int selectionDelete(String[] bids) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		 for (String bid : bids) {
	            String[] bidValues = bid.split(","); // 쉼표로 구분된 값을 분리
	            for (String value : bidValues) {
	                int intBid = Integer.parseInt(value.trim()); 
	                result = dao.selectionDelete(intBid);
	            }
		 }
	   return result;
	}

	// 장바구니에서 구매 페이지로 보내기
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


}
