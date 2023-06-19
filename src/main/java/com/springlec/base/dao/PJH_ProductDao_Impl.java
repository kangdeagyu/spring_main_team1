package com.springlec.base.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<PJH_ProductDto> search1(String list, String query) throws Exception {
		  if (list.equals("pcategory")) {
		        Map<String, String> keywordMap = new HashMap<>();
		        keywordMap.put("조", "0");
		        keywordMap.put("명", "0");
		        keywordMap.put("미", "1");
		        keywordMap.put("니", "1");
		        keywordMap.put("어", "1");
		        keywordMap.put("쳐", "1");
		        keywordMap.put("의", "2");
		        keywordMap.put("자", "2");

		        String pcategory = "";
		        for (int i = 0; i < query.length(); i++) {
		            String keyword = query.substring(i, i + 1);
		            if (keywordMap.containsKey(keyword)) {
		                pcategory = keywordMap.get(keyword);
		                System.out.println(pcategory);
		                break;
		            }
		        }

		        String uploadPath = "image/";
		        Map<String, Object> params = new HashMap<>();
		        params.put("pcategory", pcategory);
		        List<PJH_ProductDto> dtos = sqlSession.selectList(nameSpace + ".search1", params);

		        for (PJH_ProductDto dto : dtos) {
		            String category = dto.getC_name();
		            String c_name;
		            switch (category) {
		                case "0":
		                    c_name = "조명";
		                    break;
		                case "1":
		                    c_name = "미니어쳐";
		                    break;
		                case "2":
		                    c_name = "의자";
		                    break;
		                default:
		                    c_name = "";
		                    break;
		            }
		            dto.setC_name(c_name);

		            String fileName = dto.getPfilename();
		            String imagePath = uploadPath + fileName;
		            dto.setPfilename(imagePath);
		            int price = dto.getPprice();
		            System.out.println(dto.getC_name());
		        }

		        return dtos;
		    } else if (list.equals("pname")) {
		        String uploadPath = "image/";
		        Map<String, Object> params = new HashMap<>();
		        params.put("pname", query);
		        List<PJH_ProductDto> dtos = sqlSession.selectList(nameSpace + ".search1", params);

		        for (PJH_ProductDto dto : dtos) {
		            String category = dto.getC_name();
		            String c_name;
		            switch (category) {
		                case "0":
		                    c_name = "조명";
		                    break;
		                case "1":
		                    c_name = "미니어쳐";
		                    break;
		                case "2":
		                    c_name = "의자";
		                    break;
		                default:
		                    c_name = "";
		                    break;
		            }
		            dto.setC_name(c_name);

		            String fileName = dto.getPfilename();
		            String imagePath = uploadPath + fileName;
		            dto.setPfilename(imagePath);
		            int price = dto.getPprice();
		            System.out.println(dto.getC_name());
		        }

		        return dtos;
		    }

		    return null; // 혹은 적절한 오류 처리를 수행
		}
	@Override
	public void saveProduct1(Map<String, Object> params) throws Exception {
		
		 sqlSession.insert(nameSpace + ".saveProduct1", params);
		
	}

}
