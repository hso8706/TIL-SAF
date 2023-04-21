package com.ssafy.controller;

import com.ssafy.service.ProductService;
import com.ssafy.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping(value = {"/","/index"})
    public String index(Model model){
        return "index";
    }

    @GetMapping(value ="/productList")
    public String productLIst(Model model) throws SQLException {
        List<Product> list = service.selectAll();
        model.addAttribute("list", list);
        return "productList";
    }

    @GetMapping(value ="/read")
    public String read(Model model, String code) throws SQLException {
        Product p = service.selectOne(code);
        model.addAttribute("p", p);
        return "read";
    }

    @GetMapping(value ="/insertProductForm")
    public String updateProduct() {
        return "insertProductForm";
    }

    @PostMapping (value ="/insertProductProcess")
    public String deleteProduct(Product p) throws SQLException {
        service.insertOne(p);
        return "redirect:/productList";
    }

    @GetMapping(value ="/loginForm")
    public String loginForm() {
        return "loginForm";
    }

}
