package com.ssafy.dao;

import com.ssafy.vo.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    List<Product> selectAll() throws SQLException;

    Product selectOne(String code) throws SQLException;

    int insertOne(Product p) throws SQLException;
}
