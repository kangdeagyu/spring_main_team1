package com.springlec.base.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.springlec.base.model.PJH_ProductDto;

import jakarta.servlet.http.HttpServletRequest;

public interface PJH_ProductDao_Service {

	public List<PJH_ProductDto> productList() throws Exception;
	public List<PJH_ProductDto> search1(String list, String query) throws Exception;
	public void saveProduct1(String pname, int pprice, int pstock, MultipartFile file, int pcategory, String pcontent, MultipartFile file1, MultipartFile file2, String uploadPath) throws Exception;
}
