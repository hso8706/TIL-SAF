package com.ssafy.service;

import com.ssafy.dao.ProductDao;
import com.ssafy.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductDao dao;

    @Override
    public List<Product> selectAll() throws SQLException {
        return dao.selectAll();
    }

    @Override
    public Product selectOne(String code) throws SQLException {
        return dao.selectOne(code);
    }

    @Override
    public int insertOne(Product p) throws SQLException {
        return dao.insertOne(p);
    }

    @Override
    public int deleteOne(String code) throws SQLException {
        return dao.deleteOne(code);
    }

}
