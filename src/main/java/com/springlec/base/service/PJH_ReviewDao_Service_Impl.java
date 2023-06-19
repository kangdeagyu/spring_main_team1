package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.PJH_ReviewDao;
import com.springlec.base.model.PJH_ReviewDto;
@Service
public class PJH_ReviewDao_Service_Impl implements PJH_ReviewDao_Service {

	@Autowired
	PJH_ReviewDao dao;
	
	@Override
	public List<PJH_ReviewDto> reviewList() throws Exception {
		List<PJH_ReviewDto> dtos = dao.reviewList();
		for (PJH_ReviewDto dto : dtos) {
	        String uploadPath = "image/";
	        String fileName = dto.getPfilename();
	        String imagePath = uploadPath + fileName;
	        dto.setPfilename(imagePath);
	    }
	    
	    return dtos;
	}

	@Override
	public void checkcommentAction(int f_pid, String ftitle, int fid) {
		// TODO Auto-generated method stub
		dao.checkcommentAction(f_pid, ftitle, fid);
	}

}
