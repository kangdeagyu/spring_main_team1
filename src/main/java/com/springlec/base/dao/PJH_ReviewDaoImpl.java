package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.springlec.base.model.PJH_ReviewDto;

public class PJH_ReviewDaoImpl implements PJH_ReviewDao {
	@Autowired
	SqlSession sqlSession;
	public String nameSpace = "com.springlec.base.dao.PJH_ReviewDao";

	@Override
	public List<PJH_ReviewDto> reviewList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace+".reviewList");
	}

	@Override
	public void checkcommentAction(int f_pid, String ftitle, int fid) {
		// TODO Auto-generated method stub
		sqlSession.insert(nameSpace+".checkcommentAction");
	}

}
