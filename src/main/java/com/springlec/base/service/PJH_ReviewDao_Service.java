package com.springlec.base.service;

import java.util.List;

import com.springlec.base.model.PJH_ReviewDto;

public interface PJH_ReviewDao_Service {
	
	public List<PJH_ReviewDto> reviewList() throws Exception;
	public void checkcommentAction(int f_pid, String ftitle, int fid);
}
