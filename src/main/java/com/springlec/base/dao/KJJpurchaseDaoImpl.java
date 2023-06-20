package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.KJJpurchaseDto;

public class KJJpurchaseDaoImpl implements KJJpurchaseDao {

	SqlSession sqlSession;
	public static String nameSpace = "com.springlec.base.dao.KJJpurchaseDao";


	@Override
	public List<KJJpurchaseDto> product(int pid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".product");
	}


	@Override
	public List<KJJpurchaseDto> customer(String cid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".customer");
	}
	

}
