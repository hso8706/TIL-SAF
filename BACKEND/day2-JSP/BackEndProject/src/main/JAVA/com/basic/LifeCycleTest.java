package com.basic;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LifeCycleTest", value = "/LifeCycleTest")
public class LifeCycleTest extends HttpServlet {
    public LifeCycleTest() {
        System.out.println("LifeCycleTest 생성자");
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init();
        System.out.println("init...");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("destroy...");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet...555");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost...");
    }


}
