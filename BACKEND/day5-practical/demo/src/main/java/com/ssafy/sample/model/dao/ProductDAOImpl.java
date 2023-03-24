package com.ssafy.sample.model.dao;

import com.ssafy.sample.dto.Product;
import com.ssafy.sample.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;

public class ProductDAOImpl implements ProductDAO{
    DBUtil util;

    public ProductDAOImpl() {
        util = DBUtil.getInstance();
    }

    @Override
    public ArrayList<Product> selectAll() {
        ArrayList<Product> list = new ArrayList<>();
        try {
            //1. connection
            Connection con = util.getConnection();
            //2. statement
            Statement stat = con.createStatement();
            String q = "select code, model, price from product";
            ResultSet rs = stat.executeQuery(q);

            while (rs.next()) {
                String code = rs.getString(1);
                String model = rs.getString(2);
                String price = rs.getString(3);

                Product p = new Product(code, model, price);
                list.add(p);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Product selectOne(String code) {
        Product result = null;
        try {
            Connection con = util.getConnection();
            String q = "select code, model, price from product where code = ?";
            PreparedStatement stat = con.prepareStatement(q);
            stat.setString(1, code);
            ResultSet rs = stat.executeQuery();

            if(rs.next()){
                code = rs.getString(1);
                String model = rs.getString(2);
                String price = rs.getString(3);

                result = new Product(code, model, price);
            }
            con.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int insert(Product p) {
        int rs = -1;
        try{
            Connection con = util.getConnection();
            String q = "insert into product (code, model, price) values (?, ?, ?)";
            PreparedStatement stat = con.prepareStatement(q);
            stat.setString(1, p.getCode());
            stat.setString(2, p.getModel());
            stat.setString(3, p.getCode());
            rs = stat.executeUpdate();

            con.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
