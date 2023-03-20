package com.ssafy.basic;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "life", value = "/life")
public class LifeCycle extends HttpServlet {
    public LifeCycle() {
        System.out.println("Constructor call!!!");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("Constructor call!!!");
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
