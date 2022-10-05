package com.freehoon.web.user.service;

import java.util.List;

import com.freehoon.web.user.model.UserVO;

public interface UserService {
	
	//회원 리스트
	public List<UserVO> getUserList() throws Exception;
	
	//회원 정보
	public UserVO getUserInfo(String uid) throws Exception;
	
	//회원 가입
	public void insertUser(UserVO userVO) throws Exception;
	
	//회원 수정
	public void updateUser(UserVO userVO) throws Exception;
		
	//회원 가입
	public void deleteUser(String uid) throws Exception;
	
}