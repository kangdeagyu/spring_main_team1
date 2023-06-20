package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.KJJdetailPageDto;

public class KJJdetailPageDaoImpl implements KJJdetailPageDao {

	SqlSession sqlSession;
	public static String nameSpace = "com.springlec.base.dao.KJJdetailPageDao";


	@Override
	public List<KJJdetailPageDto> listKJJdetailPageDao(int pid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".listKJJdetailPageDao");
	}



}
