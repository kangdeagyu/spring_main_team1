package com.springlec.base.service;

import java.util.List;

import com.springlec.base.model.Kms_Forum_Dto;
import com.springlec.base.model.Kms_Notice_Dto;

public interface Kms_Forum_Service {
	
	public List<Kms_Forum_Dto> writelist(int ftype) throws Exception;
	public List<Kms_Notice_Dto> noticelist() throws Exception;
	public Kms_Notice_Dto noticeView(int nid) throws Exception;
	public void writeforum(String f_cid, int f_pid, String ftitle, String fcontent) throws Exception;
	public Kms_Forum_Dto forumview(int fid) throws Exception;
	public List<Kms_Forum_Dto> commentlist(int fid) throws Exception;
	public void commentAction(String f_cid, int f_pid, String ftitle, int fid) throws Exception;
	public void commentDelete(int fid) throws Exception;
	public List<Kms_Forum_Dto> forumSearch(int ftype, String content) throws Exception;
	public void QnAwrite(String f_cid, int f_pid, String ftitle, String fcontent) throws Exception;
	public void orderingupdate(int oid) throws Exception;
	public Kms_Forum_Dto bigCommentAction(int fstep, int freforder, int fsteporder) throws Exception;
	public Kms_Forum_Dto bigCommentAction1(int fstep, int fsteporder, int freforder) throws Exception;
	public void bigCommentAction2(int fsteporder, int a, int freforder, int fref) throws Exception;
	public void bigCommentAction3(String f_cid, int f_pid, int fref, int freforder, int fstep, int fsteporder, int a, String ftitle, int fmotherid) throws Exception;
	public void bigCommentAction4(int fid) throws Exception;
	public void bigCommentAction5(String f_cid, int f_pid, int fref, int freforder, int fanswernum, String ftitle, int fmotherid) throws Exception;
	public void bigCommentAction6(int fid) throws Exception;
}
