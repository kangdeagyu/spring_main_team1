package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.Kms_Forum_Dao;
import com.springlec.base.model.Kms_Forum_Dto;
import com.springlec.base.model.Kms_Notice_Dto;

@Service
public class Kms_Forum_ServiceImpl implements Kms_Forum_Service {
	
	@Autowired
	Kms_Forum_Dao dao;

	@Override
	public List<Kms_Forum_Dto> writelist(int ftype) throws Exception {
		// TODO Auto-generated method stub
		return dao.writelist(ftype);
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
		content = "%" + content + "%";
		return dao.forumSearch(ftype, content);
	}

	@Override
	public void QnAwrite(String f_cid, int f_pid, String ftitle, String fcontent) throws Exception {
		// TODO Auto-generated method stub
		dao.QnAwrite(f_cid, f_pid, ftitle, fcontent);
	}

	@Override
	public void orderingupdate(int oid) throws Exception {
		// TODO Auto-generated method stub
		dao.orderingupdate(oid);
	}

	@Override
	public Kms_Forum_Dto bigCommentAction(int fstep, int freforder, int fsteporder) throws Exception {
		// TODO Auto-generated method stub
		return dao.bigCommentAction(fstep, freforder, fsteporder);
	}

	@Override
	public Kms_Forum_Dto bigCommentAction1(int fstep, int fsteporder, int freforder) throws Exception {
		// TODO Auto-generated method stub
		return dao.bigCommentAction1(fstep, fsteporder, freforder);
	}

	@Override
	public void bigCommentAction2(int fsteporder, int a, int freforder, int fref) throws Exception {
		// TODO Auto-generated method stub
		dao.bigCommentAction2(fsteporder, a, freforder, fref);
	}

	@Override
	public void bigCommentAction3(String f_cid, int f_pid, int fref, int freforder, int fstep, int fsteporder, int a, String ftitle,
			int fmotherid) throws Exception {
		// TODO Auto-generated method stub
		dao.bigCommentAction3(f_cid, f_pid, fref, freforder, fstep, fsteporder, a, ftitle, fmotherid);
	}

	@Override
	public void bigCommentAction4(int fid) throws Exception {
		// TODO Auto-generated method stub
		dao.bigCommentAction4(fid);
	}

	@Override
	public void bigCommentAction5(String f_cid, int f_pid, int fref, int freforder, int fanswernum, String ftitle,
			int fmotherid) throws Exception {
		// TODO Auto-generated method stub
		dao.bigCommentAction5(f_cid, f_pid, fref, freforder, fanswernum, ftitle, fmotherid);
	}

	@Override
	public void bigCommentAction6(int fid) throws Exception {
		// TODO Auto-generated method stub
		dao.bigCommentAction6(fid);
	}

	@Override
	public List<Kms_Notice_Dto> noticelist() throws Exception {
		// TODO Auto-generated method stub
		return dao.noticelist();
	}

	@Override
	public Kms_Notice_Dto noticeView(int nid) throws Exception {
		// TODO Auto-generated method stub
		return dao.noticeView(nid);
	}

	@Override
	public List<Kms_Forum_Dto> DQnAList(int pid) throws Exception {
		// TODO Auto-generated method stub
		return dao.DQnAList(pid);
	}

	@Override
	public List<Kms_Forum_Dto> DReviewList(int pid) throws Exception {
		// TODO Auto-generated method stub
		return dao.DReviewList(pid);
	}

	@Override
	public Kms_Forum_Dto QnAPname(int pid) throws Exception {
		// TODO Auto-generated method stub
		return dao.QnAPname(pid);
	}

}
