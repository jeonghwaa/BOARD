package com.freehoon.web.menu.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.freehoon.web.menu.model.MenuVO;
import com.freehoon.web.menu.service.MenuService;

@RestController
@RequestMapping(value = "/restMenu")
public class RestMenuController {
	
	// RestMenuController = 화면을 먼저 처리하고 난 후 작업하기로 하고, 이제 view 화면을 처리하도록 합니다.
	private static final Logger logger = LoggerFactory.getLogger(RestMenuController.class);
	
	@Inject
	private MenuService menuService;
	
	// 메뉴 리스트 출력
	@RequestMapping(value = "/getMenuList", method = RequestMethod.POST)
	public Map<String, Object> getMenuList() throws Exception {
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			result.put("menuList", menuService.getMenuList());
			result.put("status", "OK");
		}catch(Exception e) {
			result.put("status", "False");
			logger.info(e.getMessage());
		}
		
		return result;
		
	}
	
	// 추가
	@RequestMapping(value = "/saveMenu", method = RequestMethod.POST)
	public Map<String, Object> saveMenu(MenuVO menuVO)throws Exception {
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		logger.info("menuVO : " + menuVO.toString());
		
		try {
			menuService.saveMenu(menuVO);
			result.put("status", "OK");
		}catch(Exception e) {
			result.put("status", "False");
			logger.info(e.getMessage());
		}
		
		return result;
		
	}

	// 수정
	@RequestMapping(value = "/updateMenu", method = RequestMethod.POST)
	public Map<String, Object> updateMenu(MenuVO menuVO)throws Exception {
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			menuService.updateMenu(menuVO);
			result.put("status", "OK");
		}catch(Exception e) {
			result.put("status", "False");
			logger.info(e.getMessage());
		}
		
		return result;
		
	}

	// 삭제
	@RequestMapping(value = "/deleteMenu", method = RequestMethod.POST)
	public Map<String, Object> deleteMenu(@RequestParam("code") String code)throws Exception {
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			menuService.deleteMenu(code);
			result.put("status", "OK");
		}catch(Exception e) {
			result.put("status", "False");
			logger.info(e.getMessage());
		}
		
		return result;
		
	}

	
}
