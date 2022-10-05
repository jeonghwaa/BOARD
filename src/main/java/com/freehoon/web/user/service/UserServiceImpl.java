package com.freehoon.web.user.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.freehoon.web.user.dao.UserDAO;
import com.freehoon.web.user.model.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	UserDAO userDAO;
	
	// 회원 리스트
	@Override
	public List<UserVO> getUserList() throws Exception {
		return userDAO.getUserList();
	}

	// 회원 정보
	@Override
	public UserVO getUserInfo(String uid) throws Exception {
		return userDAO.getUserInfo(uid);
	}

	// 회원 가입
	@Override
	public void insertUser(UserVO userVO) throws Exception {
		userDAO.insertUser(userVO);
	}

	// 회원 수정
	@Override
	public void updateUser(UserVO userVO) throws Exception {
		userDAO.updateUser(userVO);
	}

	// 회원 탈퇴
	@Override
	public void deleteUser(String uid) throws Exception {
		userDAO.deleteUser(uid);
	}

}
