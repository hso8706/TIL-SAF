package com.ssafy.dao;

import com.mysql.cj.protocol.Resultset;
import com.ssafy.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao{

    @Autowired
    DataSource ds;

    @Override
    public List<Product> selectAll() throws SQLException {
        List<Product> list = new ArrayList<>();

        Connection con = ds.getConnection();
        Statement stat = con.createStatement();
        String q = "select code, model, price from product";
        ResultSet rs = stat.executeQuery(q);

        while(rs.next()){
            String code = rs.getString(1);
            String model = rs.getString(2);
            String price = rs.getString(3);
            Product p = new Product(code, model, price);
            p.setNum(String.valueOf(list.size()+1));
            list.add(p);
        }
        con.close();
        return list;
    }

    @Override
    public Product selectOne(String code) throws SQLException {
        Connection con = ds.getConnection();
        String q = "select code, model, price from product where code = ?";
        PreparedStatement stat = con.prepareStatement(q);
        stat.setString(1, code);
        ResultSet rs = stat.executeQuery();

        Product p = null;
        if (rs.next()){
            code = rs.getString(1);
            String model = rs.getString(2);
            String price = rs.getString(3);
            p = new Product(code, model, price);
        }
        con.close();
        return p;
    }

    @Override
    public int insertOne(Product p) throws SQLException {
        Connection con = ds.getConnection();
        String q = "insert into product (code, model, price)" + "values(?,?,?)";
        PreparedStatement stat = con.prepareStatement(q);
        stat.setString(1, p.getCode());
        stat.setString(2, p.getModel());
        stat.setString(3, p.getPrice());

        int check = stat.executeUpdate();
        con.close();
        return check;
    }
}
