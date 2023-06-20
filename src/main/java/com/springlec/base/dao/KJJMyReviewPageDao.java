package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.KJJMyReviewPageDto;

public interface KJJMyReviewPageDao {

	public List<KJJMyReviewPageDto> MyReviewPageDao(String cid) throws Exception;
	
}
