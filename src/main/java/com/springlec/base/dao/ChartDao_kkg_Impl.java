package com.springlec.base.dao;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.AdminExtra_Dto_kkg;

public class ChartDao_kkg_Impl implements ChartDao_kkg {

	SqlSession sqlSession;
	public String nameSpace = "com.springlec.base.dao.ChartDao_kkg";
	
	@Override
	public List<AdminExtra_Dto_kkg> dailyGraph(Timestamp startday, Timestamp endday) throws Exception {
		// TODO Auto-generated method stub
		

		return sqlSession.selectList(nameSpace+".dailyGraph");
	}

}
