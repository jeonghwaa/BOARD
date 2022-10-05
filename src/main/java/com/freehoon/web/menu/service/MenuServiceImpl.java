package com.freehoon.web.menu.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.freehoon.web.menu.dao.MenuDAO;
import com.freehoon.web.menu.model.MenuVO;

@Service
public class MenuServiceImpl implements MenuService {

	@Inject
	private MenuDAO menuDAO;

	// 메뉴 리스트
	@Override
	public List<MenuVO> getMenuList() throws Exception {
		return menuDAO.getMenuList();
	}

	// 추가
	@Override
	public void saveMenu(MenuVO menuVO) throws Exception {
		menuDAO.saveMenu(menuVO);
	}

	// 수정
	@Override
	public void updateMenu(MenuVO menuVO) throws Exception {
		menuDAO.updateMenu(menuVO);
	}

	// 삭제
	@Override
	public void deleteMenu(String code) throws Exception {
		menuDAO.deleteMenu(code);
	}

}
