package com.ssafy.homework.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet(value = "/")
public class FrontController extends HttpServlet {
    BoardController bcon;
    UserController ucon;

    public FrontController() {
        bcon = new BoardController();
        ucon = new UserController();
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        // 핵심 파트
        String reqString = request.getServletPath(); // url 경로가 변경할 때 마다 잡아낼 수 있음

        //home - controller - service - dao - db(모든 data) - view(home.jsp)로 출력
        if(reqString.equals("/home")){
            bcon.home(request, response);
        }
        //home(a tag) - /read?num= - controller - service - dao - db(해당 data) - view(read.jsp)로 출력
        else if (reqString.equals("/read")) {
            bcon.read(request,response);
        }
        //home(a tag) - inserForm - controller - service - dao - db(해당 data) - view(inserForm.jsp)로 출력
        else if (reqString.equals("/insertForm")){
            bcon.insertFrom(request, response);
        }
        //insertForm - form tag input - insertProcess 전달 - controller - service - dao - db(data 저장) - view(home.jsp)로 출력
        else if (reqString.equals("/insertProcess")){
            bcon.insertProcess(request, response);
        }
        //home(a tag) - delete - controller - service - dao - db(해당 data) - view(home.jsp)
        else if (reqString.equals("/delete")){
            bcon.delete(request, response);
        }
        //login section
        //1. login 화면으로 이동, 2. login 실시, 3. logout 기능
        //home(loginCheck) - loginForm : 화면 전환
        else if (reqString.equals("/loginForm")){
            ucon.loginForm(request, response);
        }
        //실제 로그인 처리 기능, loginForm form 태그 액션
        else if (reqString.equals("/loginProcess")){
            ucon.loginProcess(request, response);
        }
        //home - loginCheck -loginOut
        else if (reqString.equals("/logout")){
            ucon.logout(request, response);
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
