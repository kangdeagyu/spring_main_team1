package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.KAdminDto;
import com.springlec.base.model.KUserDto;

public class KUserDaoImpl implements KUserDao {
	
	SqlSession sqlSession;
	public static String nameSpace = "com.springlec.base.dao.KUserDao";

	// 유저 로그인 체크
	@Override
	public KUserDto userCheck(String cid, String cpassword) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".userCheck");
	}
	
	// 관리자 로그인 체크
	@Override
	public KAdminDto adminCheck(String cid, String cpassword) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".adminCheck");
	}
	

	// 회원가입 이메일 체크
	@Override
	public int emailCheck(String cid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".emailCheck");
	}

	// 회원가입
	@Override
	public int joinUser(String cid, String cpassword, String cname, String cphone, String cbirthdate, int cgender,
			String cpostnum, String caddress1, String caddress2) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(nameSpace + ".joinUser");
	}

	// 카카오 로그인
	@Override
	public KUserDto kakaoLogin(String cid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".kakaoLogin");
	}

	// 유저 Id 찾기
	@Override
	public String findIdCheck(String cname, String cphone) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".findIdCheck");
	}

	// 유저 Pw 찾기
	@Override
	public String findPwCheck(String cid, String cname) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".findPwCheck");
	}

	// 회원정보
	@Override
	public List<KUserDto> userList(String cid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".userList");
	}

	// 회원정보 수정
	@Override
	public int userUpdate(String cid, String cpassword, String cname, String cphone, String cbirthdate, int cgender,
			String cpostnum, String caddress1, String caddress2) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(nameSpace + ".userUpdate");
	}
	
	// 회원 비밀번호 변경
	@Override
	public int userPwChange(String cid, String password, String newpassword) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(nameSpace + ".userPwChange");
	}

	// 회원 탈퇴
	@Override
	public void userDraw(String cid) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace + ".userDraw");
	}



}
