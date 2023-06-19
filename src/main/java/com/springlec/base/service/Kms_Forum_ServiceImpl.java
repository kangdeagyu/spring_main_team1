package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.Kms_Forum_Dao;
import com.springlec.base.model.Kms_Forum_Dto;

@Service
public class Kms_Forum_ServiceImpl implements Kms_Forum_Service {
	
	@Autowired
	Kms_Forum_Dao dao;

	@Override
	public List<Kms_Forum_Dto> list(int ftype) throws Exception {
		// TODO Auto-generated method stub
		return dao.list(ftype);
	}

	@Override
	public void writeforum(String f_cid, int f_pid, String ftitle, String fcontent) throws Exception {
		// TODO Auto-generated method stub
		dao.writeforum(f_cid, f_pid, ftitle, fcontent);
	}

	@Override
	public Kms_Forum_Dto forumview(int fid) throws Exception {
		// TODO Auto-generated method stub
		return dao.forumview(fid);
	}

	@Override
	public List<Kms_Forum_Dto> commentlist(int fid) throws Exception {
		// TODO Auto-generated method stub
		return dao.commentlist(fid);
	}

	@Override
	public void commentAction(String f_cid, int f_pid, String ftitle, int fid) throws Exception {
		// TODO Auto-generated method stub
		dao.commentAction(f_cid, f_pid, ftitle, fid);
	}

	@Override
	public void commentDelete(int fid) throws Exception {
		// TODO Auto-generated method stub
		dao.commentDelete(fid);
	}

	@Override
	public List<Kms_Forum_Dto> forumSearch(int ftype, String content) throws Exception {
		// TODO Auto-generated method stub
		return dao.forumSearch(ftype, content);
	}

	@Override
	public void QnAwrite(String f_cid, int f_pid, String ftitle, String fcontent) throws Exception {
		// TODO Auto-generated method stub
		dao.QnAwrite(f_cid, f_pid, ftitle, fcontent);
	}

}
