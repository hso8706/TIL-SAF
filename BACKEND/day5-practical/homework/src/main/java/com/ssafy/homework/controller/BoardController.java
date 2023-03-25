package com.ssafy.homework.controller;

import com.ssafy.homework.service.BoardService;
import com.ssafy.homework.service.BoardServiceImpl;
import com.ssafy.homework.vo.Board;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class BoardController {
    BoardService service;

    public BoardController() {
        service = new BoardServiceImpl();
    }

    public void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Board> list = service.selectAll();
        request.setAttribute("list", list);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/home.jsp");
        dispatcher.forward(request, response);
    }

    public void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num = request.getParameter("num");
        Board board = service.selectOne(num); // service.selectOne 실행 시 조회 수 count 동시 실행
        request.setAttribute("board", board);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/read.jsp");
        dispatcher.forward(request, response);
    }

    public void insertFrom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/views/insertForm.jsp";

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    public void insertProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        String pass = request.getParameter("pass");
        String name = request.getParameter("name");
        String content = request.getParameter("content");
        Board board = new Board(null, pass, name, null, title,content,null);

        int check = service.insert(board);

        response.sendRedirect("home");
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num = request.getParameter("num");
        int check = service.delete(num);

        response.sendRedirect("home");
    }
}
