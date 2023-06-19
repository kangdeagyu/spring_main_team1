package com.springlec.base.service;

import java.util.List;

import com.springlec.base.model.PJH_ReviewDto;

public interface PJH_ReviewDao_Service {
	
	public List<PJH_ReviewDto> reviewList() throws Exception;
	public void checkcommentAction(int f_pid, String ftitle, int fid) throws Exception;
	public void deleteReview(int pid);
	public List<PJH_ReviewDto> forumView(int fid) throws Exception;
	public List<PJH_ReviewDto> commentList(int fid) throws Exception;
}
