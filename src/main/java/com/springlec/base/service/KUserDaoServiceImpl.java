package com.springlec.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.KUserDao;
import com.springlec.base.model.KUserDto;

import jakarta.servlet.http.HttpSession;

@Service
public class KUserDaoServiceImpl implements KUserDaoService {

	@Autowired
	KUserDao dao;
	
	// 회원 체크
	@Override
	public String userCheck(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		KUserDto dto = dao.userCheck(username, password);
		String result = "error";
		
		if(dto != null) {
			String cname = dto.getCname();
			String cdeletedate = dto.getCdeletedate();
			
			if(cdeletedate != null) {
				result = "mdraw";
			}else {
				result = cname;
			}
		}
		
		return result;
	}

}
