package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.Kms_Forum_Dto;

public class Kms_Forum_DaoImpl implements Kms_Forum_Dao {

	SqlSession sqlSession;
	public String nameSpace = "com.springlec.base.dao.Kms_Forum_Dao";
	@Override
	public List<Kms_Forum_Dto> list(int ftype) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".list");
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
	
}
