package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.KHomeDto;

public class KHomeDaoImpl implements KHomeDao {
	
	SqlSession sqlSession;
	public static String nameSpace = "com.springlec.base.dao.KHomeDao";
	
	// 상품 전체
	@Override
	public List<KHomeDto> listHomeDao() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".listHomeDao");
	
	}

	// 상품 카테고리 별
	@Override
	public List<KHomeDto> cacategoryList(int c_cnum) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".cacategoryList");
	}

}
