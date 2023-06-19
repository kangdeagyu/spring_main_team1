package com.springlec.base.service;

import java.util.List;

import com.springlec.base.model.KHomeDto;

public interface KHomeDaoService {
	// 상품 전체
	public List<KHomeDto> listHomeDao() throws Exception;
	// 상품 카테고리 별
	public List<KHomeDto> cacategoryList(int c_cnum) throws Exception;
	// 상품 검색
	public List<KHomeDto> searchList(String search) throws Exception;
}
