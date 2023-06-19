package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.Kms_Forum_Dto;

public interface Kms_Forum_Dao {
	
	public List<Kms_Forum_Dto> list(int ftype) throws Exception;
	public void writeforum(String f_cid, int f_pid, String ftitle, String fcontent) throws Exception;
	public Kms_Forum_Dto forumview(int fid) throws Exception;
	public List<Kms_Forum_Dto> commentlist(int fid) throws Exception;
}
