//package com.freehoon.web.error.controller;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//@ControllerAdvice
//public class CommonExceptionAdvice {
//	
//	// 예외처리 방법은 예외 처리를 할 "예외 처리 전용 컨트롤러" 만드는 것
//	//@controller 를 대신해서 @controllerAdvice 어노테이션을 사용
//	
//	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);
//
//	@ExceptionHandler(RuntimeException.class)
//	public String errorException(Model model, Exception e) {
//		logger.info("@ControllerAdvice 방식 \n###exeption : " + e.getMessage());
//		model.addAttribute("exception", e);
//		return "error/exception";
//	}
//
//}
