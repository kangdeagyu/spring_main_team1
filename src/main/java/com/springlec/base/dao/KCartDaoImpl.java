package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.KCartDto;
import com.springlec.base.model.KCartOrderDto;


public class KCartDaoImpl implements KCartDao {

	SqlSession sqlSession;
	public static String nameSpace = "com.springlec.base.dao.KCartDao";
	
	// 장바구니
	@Override
	public List<KCartDto> userCart(String cid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".userCart");
	}

	// 장바구니 수량 변경
	@Override
	public int qtyChange(int pid, int qty) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(nameSpace + ".qtyChange");
	}

	// 선택한 상품 삭제
	@Override
	public int selectionDelete(int bid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(nameSpace + ".selectionDelete");
	}

	// 장바구니 -> 구매 페이지	
	@Override
	public List<KCartOrderDto> cartOrder(int bid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".cartOrder");
	}

}
