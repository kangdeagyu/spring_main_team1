package com.springlec.base.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.springlec.base.model.PJH_ProductDto;

import jakarta.servlet.http.HttpServletRequest;

public interface PJH_ProductDao_Service {

	public List<PJH_ProductDto> productList() throws Exception;
	public List<PJH_ProductDto> search1(String list, String query) throws Exception;
	public void saveProduct1(String pname, int pprice, int pstock, MultipartFile file, int pcategory, String pcontent, MultipartFile file1, MultipartFile file2, String uploadPath) throws Exception;
	public void modify(String pname, int pprice, int pstock, MultipartFile pfilename, String pcontent, MultipartFile pcontentfilename1, MultipartFile pcontentfilename2, int pid, String uploadPath) throws Exception;
	public void modify1(int pid, int modifiedQty) throws Exception;
	public int modify2(int pid) throws Exception;
	public void delete(int[] pidArray) throws Exception;
	public List<PJH_ProductDto> search2(String query) throws Exception;
}
