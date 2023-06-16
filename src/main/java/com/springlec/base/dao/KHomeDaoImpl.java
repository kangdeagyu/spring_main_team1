package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.KHomeDto;

public class KHomeDaoImpl implements KHomeDao {
	
	SqlSession sqlSession;
	public static String nameSpace = "com.springlec.base.dao.KHomeDao";
	
	@Override
	public List<KHomeDto> listHomeDao() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".listHomeDao");
	
	}

}
