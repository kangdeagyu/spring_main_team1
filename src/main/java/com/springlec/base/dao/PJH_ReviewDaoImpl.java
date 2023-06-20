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
	public PJH_ReviewDto forumView(int fid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace+".forumView");
	}

	@Override
	public List<PJH_ReviewDto> commentList(int fid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace+".commentList");
	}

	@Override
	public List<PJH_ReviewDto> writeList(int ftype) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace+".writeList");
	}

	@Override
	public List<PJH_ReviewDto> noticeList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace+".noticeList");
	}

	@Override
	public PJH_ReviewDto noticeView(int nid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace+".noticeView");
	}

	@Override
	public void noticeUpload(String ntitle, String ncontent) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.selectList(nameSpace+".noticeUpload");
	}

	@Override
	public void deleteReviewOrQNA(int fid) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.selectList(nameSpace+".deleteReviewOrQNA");
	}

	@Override
	public void deleteNotice(int nid) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.selectList(nameSpace+".deleteNotice");
	}

	@Override
	public List<PJH_ReviewDto> forumsearch(int ftype, String content) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace+".forumsearch");
	}

	
	
	
	@Override
	public void commentAction(int f_pid, String ftitle, int fid) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(nameSpace + ".commentAction");
	}

	@Override
	public void commentDelete(int fid) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace + ".commentDelete");
	}

	@Override
	public PJH_ReviewDto bigCommentAction(int fstep, int freforder, int fsteporder) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".bigCommentAction");
	}

	@Override
	public PJH_ReviewDto bigCommentAction1(int fstep, int fsteporder, int freforder) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".bigCommentAction1");
	}

	@Override
	public void bigCommentAction2(int fsteporder, int a, int freforder, int fref) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace + ".bigCommentAction2");
	}

	@Override
	public void bigCommentAction3(int f_pid, int fref, int freforder, int fstep, int fsteporder, int a, String ftitle,
			int fmotherid) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(nameSpace + ".bigCommentAction3");
	}

	@Override
	public void bigCommentAction4(int fid) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace + ".bigCommentAction4");
		
	}

	@Override
	public void bigCommentAction5(int f_pid, int fref, int freforder, int fanswernum, String ftitle, int fmotherid)
			throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(nameSpace + ".bigCommentAction5");
	}

	@Override
	public void bigCommentAction6(int fid) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace + ".bigCommentAction6");
	}

}
