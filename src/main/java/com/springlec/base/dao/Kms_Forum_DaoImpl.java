package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.Kms_Forum_Dto;
import com.springlec.base.model.Kms_Notice_Dto;

public class Kms_Forum_DaoImpl implements Kms_Forum_Dao {

	SqlSession sqlSession;
	public String nameSpace = "com.springlec.base.dao.Kms_Forum_Dao";
	@Override
	public List<Kms_Forum_Dto> writelist(int ftype) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".writelist");
	}
	@Override
	public void writeforum(String f_cid, int f_pid, String ftitle, String fcontent) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(nameSpace + ".writeforum");
	}
	@Override
	public Kms_Forum_Dto forumview(int fid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".forumview");
	}
	@Override
	public List<Kms_Forum_Dto> commentlist(int fid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".commentlist");
	}
	@Override
	public void commentAction(String f_cid, int f_pid, String ftitle, int fid) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(nameSpace + ".commentAction");
	}
	@Override
	public void commentDelete(int fid) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace + ".commentDelete");
	}
	@Override
	public List<Kms_Forum_Dto> forumSearch(int ftype, String content) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".forumSearch");
	}
	@Override
	public void QnAwrite(String f_cid, int f_pid, String ftitle, String fcontent) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(nameSpace + ".QnAwrite");
	}
	@Override
	public void orderingupdate(int oid) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace + ".orderingupadte");
	}
	@Override
	public Kms_Forum_Dto bigCommentAction(int fstep, int freforder, int fsteporder) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".bigCommentAction");
	}
	@Override
	public Kms_Forum_Dto bigCommentAction1(int fstep, int fsteporder, int freforder) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".bigCommentAction1");
	}
	@Override
	public void bigCommentAction2(int fsteporder, int a, int freforder, int fref) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace + ".bigCommentAction2");
	}
	@Override
	public void bigCommentAction3(String f_cid, int f_pid, int fref, int freforder, int fstep, int fsteporder, int a, String ftitle,
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
	public void bigCommentAction5(String f_cid, int f_pid, int fref, int freforder, int fanswernum, String ftitle,
			int fmotherid) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(nameSpace + ".bigCommentAction5");
	}
	@Override
	public void bigCommentAction6(int fid) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace + ".bigCommentAction6");
	}
	@Override
	public List<Kms_Notice_Dto> noticelist() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".noticeList");
	}
	@Override
	public Kms_Notice_Dto noticeView(int nid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".noticeView");
	}
	@Override
	public List<Kms_Forum_Dto> DQnAList(int pid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".DQnAList");
	}
	@Override
	public List<Kms_Forum_Dto> DReviewList(int pid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".DReviewList");
	}
	@Override
	public Kms_Forum_Dto QnAPname(int pid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".QnAPname");
	}
	
}
