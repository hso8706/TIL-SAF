package com.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.service.BoardService;
import com.mvc.service.BoardServiceImpl;
import com.mvc.vo.Board;

//FrontController에게서 요청을 넘겨 받아 Service에게 작업을 넘김
public class BoardController {
	BoardService service;// interface type

	public BoardController() {
		service = new BoardServiceImpl();// impl 객체
	}

	public void list(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Board> list = service.selectAll();// data 발생
		request.setAttribute("list", list);

		// 화면 구성하러 jsp(list.jsp)로 gogo => forward방식으로 넘어감
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/list.jsp");

		try {
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void read(HttpServletRequest request, HttpServletResponse response) {
		String num = request.getParameter("num");
		Board b = service.selectOne(num);
		request.setAttribute("b", b);

		// 화면 구성하러 jsp(read.jsp)로 gogo => forward방식으로 넘어감
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/read.jsp");

		try {
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertForm(HttpServletRequest request, HttpServletResponse response) {
		String url = "/views/insertForm.jsp";//새글 등록 화면		
		
		HttpSession ses = request.getSession();
		if (ses.getAttribute("user") == null) {//login x
			url = "/views/loginForm.jsp";
		}
		
		// view로 넘어가기(forward 방식)
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		try {
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(HttpServletRequest request, HttpServletResponse response) {
		String num = request.getParameter("num");
		int x = service.delete(num);
		try {
			response.sendRedirect("list");
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	public void insertProcess(HttpServletRequest request, HttpServletResponse response) {
		String pass = request.getParameter("pass");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String name = request.getParameter("name");
		
		Board b = new Board(null, pass, name, null, title, content, null);
		service.insert(b);
		
		try {
			response.sendRedirect("list");
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

}
