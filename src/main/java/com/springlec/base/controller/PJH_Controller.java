package com.springlec.base.controller;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springlec.base.model.PJH_ProductDto;
import com.springlec.base.service.PJH_ProductDao_Service;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PJH_Controller {

	@Autowired
	PJH_ProductDao_Service service;
	
	
	//상품 목록
	@RequestMapping("/APlist.do")
	public String productList(Model model) throws Exception{
		List<PJH_ProductDto> list = service.productList();
		model.addAttribute("list", list);
		return "Admin_ProductList_pjh";
	}
	
	
	//상품 검색
	@RequestMapping("/productQuery.do")
	public String search(Model model,@RequestParam("list") String list, @RequestParam("query") String query) throws Exception{
		System.out.println(list);
		System.out.println(query);
		List<PJH_ProductDto> searchlist = service.search1(list, query);
		System.out.println(searchlist);
	    model.addAttribute("list", searchlist);
	    return "Admin_ProductList_pjh";
	}
	
	//상품 추가 화면으로 이동
	@RequestMapping("/APinsert.do")
	public String productInsertpage(Model model) throws Exception{
		return "Admin_ProductAdd_pjh";
	}
	
	
	// 상품 추
	@RequestMapping("/AProductInsert.do")
	public String productInsert(HttpServletRequest request ,@RequestParam("pname") String pname, @RequestParam("pprice") int pprice, @RequestParam("pstock") int pstock, @RequestParam("file") MultipartFile file, @RequestParam("pcategory") int pcategory, @RequestParam("pcontent") String pcontent, @RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2, Model model)
			throws Exception{
		try {
	        String uploadPath = request.getServletContext().getRealPath("/image/");
	        service.saveProduct1(pname, pprice, pstock, file, pcategory, pcontent, file1, file2, uploadPath);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return "Admin_ProductAdd_pjh";
	}
	
	
}
