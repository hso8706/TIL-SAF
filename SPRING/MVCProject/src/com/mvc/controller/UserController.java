package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.service.UserService;
import com.mvc.service.UserServiceImpl;
import com.mvc.vo.User;

public class UserController {
	
	UserService service;
	
	public UserController() {
		service = new UserServiceImpl();
	}
	
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
		// 세션 얻기
				HttpSession session = request.getSession();
				session.setAttribute("user", null);

				// 초기화면으로 redirect
				try {
					 response.sendRedirect("list");
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

	public void loginProcess(HttpServletRequest request, HttpServletResponse response) {
		//1.사용자가 입력한 값 받아오기(id, pass)
		//2.받아온 값으로 User 객체 생성.  User user = new User(id, pass);
		//3.입력 정보가 맞는지 체크
		//boolean flag = service.check(user);
		//4.로그인 결과가 맞으면 로그인 정보 세션에 저장하고 초기화면으로 가기		
		//5.로그인 결과가 틀리면 다시 로그인 화면으로 보내기
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String remember = request.getParameter("remember");//checkbox
		
		User user = new User(id, pass);
		boolean flag = service.check(user);
		String url = "list";//ok

		if (flag) {// 로그인 성공
			// 세션 처리
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
		
			//cookie 처리---------------
			if(remember != null) {//체크박스 체크한 경우
				Cookie remem = new Cookie("remem", id);
				remem.setMaxAge(-1);
				response.addCookie(remem);
				
			}else {//체크박스 푼 경우
				//유효하지 않은 쿠키로 설정하기
				Cookie cookie = new Cookie("remem", "");				
				cookie.setMaxAge(0); // 유효하지 않은 쿠키
				response.addCookie(cookie);
			}			
			
		} else { //로그인 실패
			request.setAttribute("msg", "로그인 정보를 확인해 주세요!");
			url = "loginForm";		
		}	
		
		try {
			response.sendRedirect(url);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}








