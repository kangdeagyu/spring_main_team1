package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.PJH_ReviewDao;
import com.springlec.base.model.PJH_ReviewDto;
@Service
public class PJH_ReviewDao_Service_Impl implements PJH_ReviewDao_Service {

	@Autowired
	PJH_ReviewDao dao;
	
	@Override
	public List<PJH_ReviewDto> reviewList() throws Exception {
		List<PJH_ReviewDto> dtos = dao.reviewList();
		for (PJH_ReviewDto dto : dtos) {
	        String uploadPath = "image\\";
	        String fileName = dto.getPfilename();
	        String imagePath = uploadPath + fileName;
	        dto.setPfilename(imagePath);
	    }
	    
	    return dtos;
	}

	@Override
	public void checkcommentAction(int f_pid, String ftitle, int fid) throws Exception{
		// TODO Auto-generated method stub
		dao.checkcommentAction(f_pid, ftitle, fid);
	}

	@Override
	public void deleteReview(int pid) {
		// TODO Auto-generated method stub
		dao.deleteReview(pid);
	}

	@Override
	public PJH_ReviewDto forumView(int fid) throws Exception {
		// TODO Auto-generated method stub
		return dao.forumView(fid);
	}

	@Override
	public List<PJH_ReviewDto> commentList(int fid) throws Exception {
		// TODO Auto-generated method stub
		return dao.commentList(fid);
	}

	@Override
	public List<PJH_ReviewDto> writeList(int ftype) throws Exception {
		// TODO Auto-generated method stub
		return dao.writeList(ftype);
	}

	@Override
	public List<PJH_ReviewDto> noticeList() throws Exception {
		// TODO Auto-generated method stub
		return dao.noticeList();
	}

	@Override
	public PJH_ReviewDto noticeView(int nid) throws Exception {
		// TODO Auto-generated method stub
		return dao.noticeView(nid);
	}

	@Override
	public void noticeUpload(String ntitle, String ncontent) throws Exception {
		// TODO Auto-generated method stub
		dao.noticeUpload(ntitle, ncontent);
	}

	@Override
	public void deleteReviewOrQNA(int fid) throws Exception {
		// TODO Auto-generated method stub
		dao.deleteReviewOrQNA(fid);
	}

	@Override
	public void deleteNotice(int nid) throws Exception {
		// TODO Auto-generated method stub
		dao.deleteNotice(nid);
	}

	@Override
	public List<PJH_ReviewDto> forumsearch(int ftype, String content) throws Exception {
		// TODO Auto-generated method stub
		content= '%' + content+'%';
		return dao.forumsearch(ftype, content);
	}

	@Override
	public void commentAction(int f_pid, String ftitle, int fid) throws Exception {
		// TODO Auto-generated method stub
		dao.commentAction(f_pid, ftitle, fid);
	}

	@Override
	public void commentDelete(int fid) throws Exception {
		// TODO Auto-generated method stub
		dao.commentDelete(fid);
	}

	@Override
	public PJH_ReviewDto bigCommentAction(int fstep, int freforder, int fsteporder) throws Exception {
		// TODO Auto-generated method stub
		return dao.bigCommentAction(fstep, freforder, fsteporder);
	}

	@Override
	public PJH_ReviewDto bigCommentAction1(int fstep, int fsteporder, int freforder) throws Exception {
		// TODO Auto-generated method stub
		return dao.bigCommentAction1(fstep, fsteporder, freforder);
	}

	@Override
	public void bigCommentAction2(int fsteporder, int a, int freforder, int fref) throws Exception {
		// TODO Auto-generated method stub
		dao.bigCommentAction2(fsteporder, a, freforder, fref);
	}

	@Override
	public void bigCommentAction3(int f_pid, int fref, int freforder, int fstep, int fsteporder, int a, String ftitle,
			int fmotherid) throws Exception {
		// TODO Auto-generated method stub
		dao.bigCommentAction3(f_pid, fref, freforder, fstep, fsteporder, a, ftitle, fmotherid);
	}

	@Override
	public void bigCommentAction4(int fid) throws Exception {
		// TODO Auto-generated method stub
		dao.bigCommentAction4(fid);
	}

	@Override
	public void bigCommentAction5(int f_pid, int fref, int freforder, int fanswernum, String ftitle, int fmotherid)
			throws Exception {
		// TODO Auto-generated method stub
		dao.bigCommentAction5(f_pid, fref, freforder, fanswernum, ftitle, fmotherid);
	}

	@Override
	public void bigCommentAction6(int fid) throws Exception {
		// TODO Auto-generated method stub
		dao.bigCommentAction6(fid);
	}

	@Override
	public void noticeModify(String ntitle, String ncontent, int nid) throws Exception {
		// TODO Auto-generated method stub
		dao.noticeModify(ntitle, ncontent, nid);
	}

}
