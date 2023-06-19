package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springlec.base.dao.Kms_Forum_Dao;
import com.springlec.base.model.Kms_Forum_Dto;

public class Kms_Forum_ServiceImpl implements Kms_Forum_Dao {
	
	@Autowired
	Kms_Forum_Service dao;

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

}
