package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.KHomeDto;

public interface KHomeDao {
	// 상품 전체
	public List<KHomeDto> listHomeDao() throws Exception;
	// 상품 카테고리 별
	public List<KHomeDto> cacategoryList(int c_cnum) throws Exception;
}
