package com.springlec.base.dao;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.AdminExtra_Dto_kkg;

public class KKG_OrderDao_Impl implements KKG_OrderDao{

	
	
	SqlSession sqlSession;
	public static String nameSpace = "com.springlec.base.dao.KKG_OrderDao";
	@Override
	public List<AdminExtra_Dto_kkg> getOrderList_Default(String cid, Timestamp startday, Timestamp endday) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace+".getOrderList_Default");
	}
	@Override
	public List<AdminExtra_Dto_kkg> getOrderList_Hope(String cid, Timestamp startday, Timestamp endday)
			throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace+".getOrderList_Hope");
	}

}
