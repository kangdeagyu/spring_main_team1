package com.springlec.base.service;

public interface KOrderDaoService {

	// 상품 구매
	public void orderProduct(String cid, int pid, int qty, int price, 
			String postnum, String address1, String addess2 , String memo, String paytype) throws Exception;
	// 장바구니 삭제
	public void cartDeleteProduct(int pid) throws Exception;
	
	// 상품 재고량 삭제
	public void prodcutQtyModify(int pid, int qty) throws Exception;
}
