package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.PJH_ProductDto;

public class PJH_ProductDao_Impl implements PJH_ProductDao {
	SqlSession sqlSession;
	public String nameSpace = "com.springlec.base.dao.PJH_ProductDao";
	@Override
	public List<PJH_ProductDto> productList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace+".productList");
	}

}
