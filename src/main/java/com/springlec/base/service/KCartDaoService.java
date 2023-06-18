package com.springlec.base.service;

import java.util.List;

import com.springlec.base.model.KCartDto;

public interface KCartDaoService {

	// 유저 장바구니
	public List<KCartDto> userCart(String cid) throws Exception;
}
