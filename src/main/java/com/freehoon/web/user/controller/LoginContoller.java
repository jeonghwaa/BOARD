package com.freehoon.web.user.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.freehoon.web.user.model.UserVO;
import com.freehoon.web.user.service.UserService;

@Controller
@RequestMapping(value="/login")
public class LoginContoller {
	
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Inject
	private UserService userService;
	
	@RequestMapping(value = "/signupForm", method = RequestMethod.GET)
	public String signupForm(Model model) throws Exception {
		model.addAttribute("userVO", new UserVO());
		return "login/signupForm";
	}

}
