package com.ssafy.sample.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet(name = "WebFrontController", value = "/")
public class WebFrontController extends HttpServlet {
    ProductController pcon;
    UserController ucon;

    public WebFrontController() {
        pcon = new ProductController();
        ucon = new UserController();
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //1. client에서 server로 보내는 한글 처리
        request.setCharacterEncoding("utf-8");
        //2. servletPath 가져오기
        String reqString = request.getServletPath();
        //3. controller 뿌리기
        if (reqString.equals("/list")){
            pcon.list(request, response);
        }
        else if (reqString.equals("/read")){
            pcon.read(request, response);
        }
        else if (reqString.equals("/insert")){
            pcon.insert(request, response);
        }
        else if (reqString.equals("/insertProcess")){
            pcon.insertProcess(request, response);
        }
        else if (reqString.equals("/delete")){
            pcon.delete(request, response);
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
