package com.springlec.base.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.springlec.base.model.PJH_ReviewDto;

public interface PJH_ReviewDao_Service {
	
	public List<PJH_ReviewDto> reviewList() throws Exception;
	public void checkcommentAction(int f_pid, String ftitle, int fid) throws Exception;
	public void deleteReview(int pid);
	public PJH_ReviewDto forumView(int fid) throws Exception;
	public List<PJH_ReviewDto> commentList(int fid) throws Exception;
	public List<PJH_ReviewDto> writeList(int ftype) throws Exception;
	public List<PJH_ReviewDto> noticeList() throws Exception;
	public PJH_ReviewDto noticeView(int nid) throws Exception;
	public void noticeUpload(String ntitle, String ncontent) throws Exception;
	public void deleteReviewOrQNA(int fid) throws Exception;
	public void deleteNotice(int nid) throws Exception;
	public List<PJH_ReviewDto> forumsearch(int ftype, String content) throws Exception;
}
