package com.springlec.base.dao;

import com.springlec.base.model.KUserDto;

public interface KUserDao {

	public KUserDto userCheck(String username, String password) throws Exception;
}
