package com.ssafy.sample.controller;

import com.ssafy.sample.dto.Product;
import com.ssafy.sample.model.service.ProductService;
import com.ssafy.sample.model.service.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductController {
    ProductService pservice;

    public ProductController() {
        pservice = new ProductServiceImpl();
    }

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Product> products = pservice.selectAll();
        request.setAttribute("products", products);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/list.jsp");
        dispatcher.forward(request,response);
    }

    public void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        Product p = pservice.selectOne(code);
        request.setAttribute("p", p);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/read.jsp");
        dispatcher.forward(request,response);
    }

    public void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/regist.jsp");
        dispatcher.forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) {
    }

    public void insertProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String code = request.getParameter("code");
        String name = request.getParameter("model");
        String price = request.getParameter("price");
        Product p = new Product(code, name, price);
        int result = pservice.insert(p);

        response.sendRedirect("/web_Sample/list");
    }
}
