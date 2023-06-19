package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.PJH_ReviewDto;


public interface PJH_ReviewDao {

	
	public List<PJH_ReviewDto> reviewList() throws Exception;
	public void checkcommentAction(int f_pid, String ftitle, int fid);
	
}
