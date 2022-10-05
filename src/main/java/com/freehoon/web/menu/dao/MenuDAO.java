package com.freehoon.web.menu.dao;

import java.util.List;

import com.freehoon.web.menu.model.MenuVO;

public interface MenuDAO {

	// 메뉴 리스트
	public List<MenuVO> getMenuList() throws Exception;

	// 추가
	public int saveMenu(MenuVO menuVO) throws Exception;

	// 수정
	public int updateMenu(MenuVO menuVO) throws Exception;
	
	// 삭제
	public int deleteMenu(String code) throws Exception;


}
