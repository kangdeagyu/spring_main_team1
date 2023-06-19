package com.springlec.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springlec.base.dao.KOrderDao;

@Service
public class KOrderDaoServiceImpl implements KOrderDaoService {

	@Autowired
	KOrderDao dao;
	
	// 상품구매
	@Override
	public void orderProduct(String cid, int pid, int qty, int price, String postnum, String address1,
			String addess2, String memo, String paytype) throws Exception {
		// TODO Auto-generated method stub
			
			dao.orderProduct(cid, pid, qty, price, postnum, address1, addess2, memo, paytype);
		
	}

	// 장바구니 변경
	@Override
	public void cartDeleteProduct(int pid) throws Exception {
		// TODO Auto-generated method stub
		dao.cartDeleteProduct(pid);
	}

	// 상품 수량 변경
	@Override
	public void prodcutQtyModify(int pid, int qty) throws Exception {
		// TODO Auto-generated method stub
		dao.prodcutQtyModify(pid, qty);
	}

}
