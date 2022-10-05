package com.freehoon.web.menu.service;

import java.util.List;

import com.freehoon.web.menu.model.MenuVO;

public interface MenuService {
	
	// 메뉴 리스트
	public List<MenuVO> getMenuList() throws Exception;
	
	// 추가
	public void saveMenu(MenuVO menuVO) throws Exception;
	
	// 수정
	public void updateMenu(MenuVO menuVO) throws Exception;
	
	// 삭제
	public void deleteMenu(String code) throws Exception;

}
