package com.mvc.controller;

import com.mvc.service.BoardService;
import com.mvc.service.BoardServiceImpl;
import com.mvc.vo.Board;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

//FrontController 에게서 요청을 넘겨 받아 Service 에게 작업을 넘김
public class BoardController {
    //선언은 interface 타입, 생성은 impl 객체
    BoardService service; // service에 작업을 넘기기 위함

    public BoardController() {
        service = new BoardServiceImpl(); //impl 객체
    }

    //list(): data 를 전부 호출하여 메인 페이지 화면에 띄운다.
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Board> list = service.selectAll(); //data 발생
        request.setAttribute("list", list); // data 를 request 를 이용하여 넘겨주기 위함

        //화면 구성하러 jsp로 gogo => forward 방식으로 넘어감(dispatcher 사용)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/list.jsp");
        dispatcher.forward(request, response);
    }
    public void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num = request.getParameter("num");
        Board b = service.selectOne(num);
        request.setAttribute("b", b);

        //화면 구성하러 jsp로 gogo => forward 방식으로 넘어감(dispatcher 사용)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/read.jsp");
        dispatcher.forward(request, response);
    }


    public void insertForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //화면 구성하러 jsp로 gogo => forward 방식으로 넘어감(dispatcher 사용)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/insertForm.jsp");
        dispatcher.forward(request, response);
    }

    public void insertProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        String pass = request.getParameter("pass");
        String name = request.getParameter("name");
        String content = request.getParameter("content");
        Board b = new Board(null, pass, name, null, title, content, null);
        int check = service.insert(b);

        response.sendRedirect("/mvc/list");
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
}
