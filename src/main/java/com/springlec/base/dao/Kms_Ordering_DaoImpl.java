package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.Kms_Ordering_Dto;

public class Kms_Ordering_DaoImpl implements Kms_Ordering_Dao {

	SqlSession sqlSession;
	public String nameSpace = "com.springlec.base.dao.Kms_Ordering_Dao";
	@Override
	public List<Kms_Ordering_Dto> orderinglist(String cid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".orderinglist");
	}
	@Override
	public void orderRefund(int oid) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace + ".orderRefund");
	}
	

}
