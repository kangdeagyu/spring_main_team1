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
	// 상품 전체
	@Override
	public List<KHomeDto> listHomeDao() throws Exception {
		// TODO Auto-generated method stub
		return dao.listHomeDao();
	}

	// 상품 카테고리 별
	@Override
	public List<KHomeDto> cacategoryList(int c_cnum) throws Exception {
		// TODO Auto-generated method stub
		return dao.cacategoryList(c_cnum);
	}

	@Override
	public List<KHomeDto> searchList(String search) throws Exception {
		// TODO Auto-generated method stub
		search = "%" + search + "%";
		return dao.searchList(search);
	}

}
