package com.ssafy.sample.model.dao;

import com.ssafy.sample.dto.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductDAO {
    ArrayList<Product> selectAll();

    int insert(Product p);

    Product selectOne(String code);
}
