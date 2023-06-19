package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.KHomeDao;
import com.springlec.base.model.KHomeDto;

@Service
public class KHomeDaoServiceImpl implements KHomeDaoService {

	@Autowired
	KHomeDao dao;
	
	@Override
	public List<KHomeDto> listHomeDao() throws Exception {
		// TODO Auto-generated method stub
		return dao.listHomeDao();
	}

}
