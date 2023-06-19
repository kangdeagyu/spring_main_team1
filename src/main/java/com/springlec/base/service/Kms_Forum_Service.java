package com.springlec.base.service;

import java.util.List;

import com.springlec.base.model.Kms_Forum_Dto;

public interface Kms_Forum_Service {
	
	public List<Kms_Forum_Dto> list(int ftype) throws Exception;
	public void writeforum(String f_cid, int f_pid, String ftitle, String fcontent) throws Exception;
	public Kms_Forum_Dto forumview(int fid) throws Exception;
}
