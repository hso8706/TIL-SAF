package com.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;

@ControllerAdvice
public class ExceptionControllerAdvice {

	private final Logger logger = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

	@ExceptionHandler(MysqlDataTruncation.class)
	public String handleException(Exception ex, Model model) {
		logger.error("Exception 발생 : {}", ex.getMessage());
		model.addAttribute("msg", "입력 데이터 길이가 너무 깁니다!!!");
		return "error/error";
	}	
	
	@ExceptionHandler(Exception.class)
	public String handleException2(Exception ex, Model model) {
		logger.error("Exception 발생 : {}", ex.getMessage());
		model.addAttribute("msg", "처리중 에러 발생!!!" + ex);
		return "error/error";
	}	
}

/*
 예외처리
1.service에 throws Exception
2.serviceImpl에 throws Exception

3.dao에 throws SQLException
4.daoImpl에 throws SQLException & 메소드 안에서 try~catch 지우기

5.controller에 throws Exception

6.controller안에 예외처리 핸들러 추가 @ExceptionHandler(우선순위 높음)

7.전역 예외처리 클래스 추가 @ControllerAdvice

 
*/