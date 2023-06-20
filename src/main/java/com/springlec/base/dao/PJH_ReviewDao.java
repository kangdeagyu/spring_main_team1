package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.springlec.base.model.PJH_ReviewDto;


public interface PJH_ReviewDao {

	
	public List<PJH_ReviewDto> reviewList() throws Exception;
	public void checkcommentAction(@Param("f_pid") int f_pid, @Param("ftitle") String ftitle,@Param("fid") int fid) throws Exception;
	public void deleteReview(int pid);
	public PJH_ReviewDto forumView(int fid) throws Exception;
	public List<PJH_ReviewDto> commentList(int fid) throws Exception;
	public List<PJH_ReviewDto> writeList(int ftype) throws Exception;
	public List<PJH_ReviewDto> noticeList() throws Exception;
	public PJH_ReviewDto noticeView(int nid) throws Exception;
	public void noticeUpload(@Param("ntitle") String ntitle, @Param("ncontent") String ncontent) throws Exception;
	public void deleteReviewOrQNA(@Param("fid") int fid) throws Exception;
	public void deleteNotice(@Param("nid") int nid) throws Exception;
	public List<PJH_ReviewDto> forumsearch(@Param("ftype") int ftype, @Param("content") String content) throws Exception;
}
