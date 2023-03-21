package com.basic;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

//서블릿: 웹에서 실행되는 자바 프로그램
//http://localhost:8080/backend/Hello => get 방식의 요청(주소로 직접 요청)
@WebServlet(name = "Servlet", value = "/Hello")
public class Servlet extends HttpServlet {

    //서비스 메소드
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8"); // 응답으로 클라이언트에 나갈 컨텐트의 타입을 지정
        PrintWriter out = response.getWriter(); // 클라이언트로 보내기 위한 출력용 스트림
        out.println("<html><body>");
        out.println("<h1>Hello Servlet Test</h1>");
        out.println("<a href=Message>메세지 서블릿으로 가기</a>");
        out.println("</body></html>");
    }

    //서비스 메소드
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8"); // 응답으로 클라이언트에 나갈 컨텐트의 타입을 지정
        PrintWriter out = response.getWriter(); // 클라이언트로 보내기 위한 출력용 스트림
        out.println("<html><body>");
        out.println("<h1>Servlet Test</h1>");
        out.println("</body></html>");
    }
}
