package com.freehoon.web.user.dao;

import java.util.List;

import com.freehoon.web.user.model.UserVO;

public interface UserDAO {
	
	//회원 리스트
	public List<UserVO> getUserList() throws Exception;
	
	//회원 정보
	public UserVO getUserInfo(String uid) throws Exception;
	
	//회원 가입
	public int insertUser(UserVO userVO) throws Exception;
	
	//회원 수정
	public int updateUser(UserVO userVO) throws Exception;
		
	//회원 가입
	public int deleteUser(String uid) throws Exception;
		
	
	
	
	
}