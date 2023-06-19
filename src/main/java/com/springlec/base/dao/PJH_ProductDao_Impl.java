package com.springlec.base.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.PJH_ProductDto;

public class PJH_ProductDao_Impl implements PJH_ProductDao {
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
            // 단어와 인식값을 매핑하는 Map을 생성합니다.
            Map<String, String> keywordMap = new HashMap<>();
            keywordMap.put("조", "0");
            keywordMap.put("명", "0");
            keywordMap.put("미", "1");
            keywordMap.put("니", "1");
            keywordMap.put("어", "1");
            keywordMap.put("쳐", "1");
            keywordMap.put("의", "2");
            keywordMap.put("자", "2");

            // 입력된 쿼리를 한 글자씩 확인하고 해당하는 인식값을 설정합니다.
            String pcategory = "";
            for (int i = 0; i < query.length(); i++) {
                String keyword = query.substring(i, i + 1);
                if (keywordMap.containsKey(keyword)) {
                    pcategory = keywordMap.get(keyword);
                    break;
                }
            }
            return sqlSession.selectList(nameSpace + "searchByCategory", pcategory);
        } else if (list.equals("pname")) {
            return sqlSession.selectList(nameSpace + "searchByName", query);
        }
        return new ArrayList<>();
    }

}
