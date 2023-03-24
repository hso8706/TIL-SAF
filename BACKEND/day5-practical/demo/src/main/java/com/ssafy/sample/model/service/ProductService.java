package com.ssafy.sample.model.service;

import com.ssafy.sample.dto.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductService {
    ArrayList<Product> selectAll();

    int insert(Product p);

    Product selectOne(String code);
}
