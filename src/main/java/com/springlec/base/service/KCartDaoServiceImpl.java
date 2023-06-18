package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.KCartDao;
import com.springlec.base.model.KCartDto;

@Service
public class KCartDaoServiceImpl implements KCartDaoService {

	@Autowired
	KCartDao dao;
	
	@Override
	public List<KCartDto> userCart(String cid) throws Exception {
		// TODO Auto-generated method stub
		return dao.userCart(cid);
	}

}
