package com.springlec.base.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.springlec.base.model.PJH_ProductDto;

public class PJH_ProductDao_Impl implements PJH_ProductDao {
	@Autowired
	SqlSession sqlSession;
	public String nameSpace = "com.springlec.base.dao.PJH_ProductDao";
	@Override
	public List<PJH_ProductDto> productList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace+".productList");
	}
	@Override
	public List<PJH_ProductDto> search1(@Param("list") String list, @Param("query") String query) throws Exception {
		return sqlSession.selectList(nameSpace+".search1");
	}
	@Override
	public void saveProduct1(Map<String, Object> params) throws Exception {
		
		 sqlSession.insert(nameSpace + ".saveProduct1", params);
		
	}
	@Override
	public void modify(Map<String, Object> params) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace + ".modify", params);
	}
	
	@Override
	public void delete(int pid) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace+".delete");
	}

}
