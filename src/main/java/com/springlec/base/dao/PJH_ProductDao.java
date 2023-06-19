package com.springlec.base.dao;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.springlec.base.model.PJH_ProductDto;

public interface PJH_ProductDao {

	public List<PJH_ProductDto> productList() throws Exception;
	public List<PJH_ProductDto> search1(String list, String query) throws Exception;
	public void saveProduct1(Map<String, Object> params) throws Exception;
}
