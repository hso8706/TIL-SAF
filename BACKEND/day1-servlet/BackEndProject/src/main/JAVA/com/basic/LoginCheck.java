package com.basic;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginCheck", value = "/LoginCheck")
public class LoginCheck extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1) client에서 server로 들어오는 정보에서 한글이 안깨지게 하기 위함. post 시 필수로 해줄 것
        request.setCharacterEncoding("utf-8");
        //2) 클라이언트가 보내는 데이터 받기
        String id = request.getParameter("id"); //.getParameter() : html의 name 속성 값 기준으로 받아옴
        String pass = request.getParameter("pass");

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>Login Result</h1>");
        out.println("<h1>" + id + "님, 환영합니다~</h1>");
        out.println("<h3> password는" + pass + "입니다.</h3>");
        out.println("</body></html>");
    }
}
