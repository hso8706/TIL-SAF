package com.basic;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Survey", value = "/Survey")
public class Survey extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        String dept = request.getParameter("dept");
        String employee = request.getParameter("employee");
        String comment = request.getParameter("comment");
        String[] ide = request.getParameterValues("ide"); // 다중 선택을 받기 위함

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>dept survey</h1>");
        out.println("<h1> dept: " + dept + "</h1>");
        out.println("<h1> employee: " + employee + "</h1>");
        out.println("<h1> comment: " + comment + "</h1>");
        for (int i = 0; i < ide.length; i++) {
            out.println("<h1> ide"+ i + ": " + ide[i] + "</h1>");
        }
        out.println("</body></html>");
    }
}
