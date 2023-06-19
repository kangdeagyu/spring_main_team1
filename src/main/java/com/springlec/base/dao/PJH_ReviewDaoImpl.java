package com.springlec.base.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public void checkcommentAction(int f_pid, String ftitle, int fid) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
	    paramMap.put("f_pid", f_pid);
	    paramMap.put("ftitle", ftitle);
	    paramMap.put("fid", fid);
		sqlSession.insert(nameSpace+".checkcommentAction", paramMap);
	}

	@Override
	public void deleteReview(int pid) {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace+".deleteReview");
	}

	@Override
	public List<PJH_ReviewDto> forumView(int fid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace+".forumView");
	}

	@Override
	public List<PJH_ReviewDto> commentList(int fid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace+".commentList");
	}

}
