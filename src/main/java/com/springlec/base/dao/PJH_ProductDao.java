package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.PJH_ProductDto;

public interface PJH_ProductDao {

	public List<PJH_ProductDto> productList() throws Exception;
}
