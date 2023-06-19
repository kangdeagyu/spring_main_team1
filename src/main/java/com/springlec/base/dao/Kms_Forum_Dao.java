package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.Kms_Forum_Dto;

public interface Kms_Forum_Dao {
	
	public List<Kms_Forum_Dto> list(int ftype) throws Exception;

}
