package com.mvc.front;

import com.mvc.controller.BoardController;
import com.mvc.controller.UserController;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
//클라이언트로부터 들어오는 요청 받기. 받은 요청을 구분한 뒤 Controller에게 넘기기

/*
- (초기화면) http://localhost:8080/mvc/list.mvc
- (상세화면) http://localhost:8080/mvc/read.mvc
- (등록을 위한 입력 화면) http://localhost:8080/mvc/insertForm.mvc
- (입력 처리) http://localhost:8080/mvc/insertProcess.mvc-->저장 후 초기화면으로 돌아오기
- (삭제) http://localhost:8080/mvc/delete.mvc-->삭제 후 초기화면으로 돌아오기
- (로그인을 위한 입력화면) http://localhost:8080/mvc/loginForm.mvc
- (로그인처리) http://localhost:8080/mvc/loginProcess.mvc
 */

//@WebServlet(value = "*.mvc")
@WebServlet(value = "/")
public class BoardFrontController extends HttpServlet {
    BoardController con; //BoardController에게 작업을 넘기기 위함
    UserController ucon; // login, logout, loginProcess

    public BoardFrontController() {
        con = new BoardController();
        ucon = new UserController();
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reqString = request.getServletPath(); //client 가 보낸 url 구분하는 문자열
//        System.out.println(reqString); // 마지막 `/`부터 .mvc 까지의 경로 값
        if (reqString.equals("/list")) {
            con.list(request, response);
        } else if (reqString.equals("/read")) {
            con.read(request, response);
        } else if (reqString.equals("/insertForm")) {
            con.insertForm(request, response);
        } else if (reqString.equals("/insertProcess")) {
            con.insertProcess(request, response);
        } else if (reqString.equals("/delete")) {

        } else if (reqString.equals("/loginForm")) { // 로그인 화면
            ucon.loginForm(request, response);
        } else if (reqString.equals("/logout")) { // 로그아웃
            ucon.logout(request, response);
        } else if (reqString.equals("/loginProcess")) { // 로그인 처리(db 체크,
            ucon.loginProcess(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }
}
