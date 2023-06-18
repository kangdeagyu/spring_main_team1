package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.KCartDto;

public interface KCartDao {

	// 유저 장바구니
	public List<KCartDto> userCart(String cid) throws Exception;
}
