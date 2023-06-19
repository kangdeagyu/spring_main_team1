package com.springlec.base.service;

import java.util.List;

import com.springlec.base.model.Kms_Forum_Dto;

public interface Kms_Forum_Service {
	
	public List<Kms_Forum_Dto> list(int ftype) throws Exception;

}
