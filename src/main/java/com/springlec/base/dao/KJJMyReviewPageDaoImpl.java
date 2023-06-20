package com.springlec.base.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.KJJMyReviewPageDto;

public class KJJMyReviewPageDaoImpl implements KJJMyReviewPageDao {

	SqlSession sqlSession;
	public static String nameSpace = "com.springlec.base.dao.KJJMyReviewPageDao";

	@Override
	public List<KJJMyReviewPageDto> MyReviewPageDao(String cid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".MyReviewPageDao");

	
	}


	

}
