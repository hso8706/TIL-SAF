package com.mvc.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.service.UserService;

public class UserController {
	
	UserService service;
	
	public void loginForm(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/loginForm.jsp");

		try {
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void logout(HttpServletRequest request, HttpServletResponse response) {
		// 세션에 저장된 로그인 정보를 삭제하고 초기화면으로 가기
		
	}

	public void loginProcess(HttpServletRequest request, HttpServletResponse response) {
		//1.사용자가 입력한 값 받아오기(id, pass)
		//2.받아온 값으로 User 객체 생성.  User user = new User(id, pass);
		//3.입력 정보가 맞는지 체크
		//boolean flag = service.check(user);
		//4.로그인 결과가 맞으면 로그인 정보 세션에 저장하고 초기화면으로 가기
		
		//5.로그인 결과가 틀리면 다시 로그인 화면으로 보내기
	
	
	
	
	}
}
