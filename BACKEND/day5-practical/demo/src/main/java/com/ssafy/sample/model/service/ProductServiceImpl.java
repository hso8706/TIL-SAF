package com.ssafy.sample.model.service;

import com.ssafy.sample.dto.Product;
import com.ssafy.sample.model.dao.ProductDAO;
import com.ssafy.sample.model.dao.ProductDAOImpl;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProductServiceImpl implements ProductService{
    ProductDAO pdao;

    public ProductServiceImpl() {
        pdao = new ProductDAOImpl();
    }

    @Override
    public ArrayList<Product> selectAll() {
        return pdao.selectAll();
    }

    @Override
    public Product selectOne(String code) {
        return pdao.selectOne(code);
    }

    @Override
    public int insert(Product p) {
        return pdao.insert(p);
    }
}
