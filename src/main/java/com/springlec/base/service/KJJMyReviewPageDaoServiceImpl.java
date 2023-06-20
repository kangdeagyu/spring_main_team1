package com.springlec.base.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.KJJMyReviewPageDao;
import com.springlec.base.model.KJJMyReviewPageDto;

@Service
public class KJJMyReviewPageDaoServiceImpl implements KJJMyReviewPageDaoService {

	@Autowired
	KJJMyReviewPageDao dao;

	@Override
	public List<KJJMyReviewPageDto> MyReviewPageDao(String cid) throws Exception {
		// TODO Auto-generated method stub
		return dao.MyReviewPageDao(cid);
	}




	


}
