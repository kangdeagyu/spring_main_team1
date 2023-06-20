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
	
	
	
	public void commentAction(int f_pid, String ftitle, int fid) throws Exception;
	public void commentDelete(int fid) throws Exception;
	public PJH_ReviewDto bigCommentAction(int fstep, int freforder, int fsteporder) throws Exception;
	public PJH_ReviewDto bigCommentAction1(int fstep, int fsteporder, int freforder) throws Exception;
	public void bigCommentAction2(int fsteporder, int a, int freforder, int fref) throws Exception;
	public void bigCommentAction3(int f_pid, int fref, int freforder, int fstep, int fsteporder, int a, String ftitle, int fmotherid) throws Exception;
	public void bigCommentAction4(int fid) throws Exception;
	public void bigCommentAction5(int f_pid, int fref, int freforder, int fanswernum, String ftitle, int fmotherid) throws Exception;
	public void bigCommentAction6(int fid) throws Exception;
	
	
	
	
	public void noticeModify(String ntitle, String ncontent, int nid) throws Exception;
}
