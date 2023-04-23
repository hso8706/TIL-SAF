package com.ssafy.service;

import com.ssafy.vo.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    List<Product> selectAll() throws SQLException;

    Product selectOne(String code) throws SQLException;

    int insertOne(Product p) throws SQLException;

    int deleteOne(String code) throws SQLException;
}
