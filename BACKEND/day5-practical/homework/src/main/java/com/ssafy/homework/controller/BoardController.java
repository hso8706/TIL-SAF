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
        Board board = service.selectOne(num);
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

        response.sendRedirect("/homework/home");
    }
}
