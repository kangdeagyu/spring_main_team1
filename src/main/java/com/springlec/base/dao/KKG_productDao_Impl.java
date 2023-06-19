package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.AdminExtra_Dto_kkg;

public class KKG_productDao_Impl implements KKG_productDao {

	SqlSession sqlSession;
	public String nameSpace = "com.springlec.base.dao.KKG_productDao";
	@Override
	public List<AdminExtra_Dto_kkg> getOutStocks() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace+".getOutStocks");
	}

	
	
	
}
