package com.freehoon.web.menu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.freehoon.web.menu.model.MenuVO;

@Controller
@RequestMapping(value = "/menu")
public class MenuController {
	

	//메뉴 리스트
	@RequestMapping(value = "/getMenuList", method = RequestMethod.GET)
	public String getMenuList(Model m) {
		
		m.addAttribute("menuVO", new MenuVO());
		
		return "menu/menu";
		
	}
	

}
