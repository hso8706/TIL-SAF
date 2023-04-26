package com.mvc.service;

import com.mvc.mapper.CustomerMapper;
import com.mvc.vo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerMapper mapper;

    @Override
    public List<Customer> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public Customer selectOne(String num) {
        return mapper.selectOne(num);
    }

    @Override
    public int insert(Customer c) {
        return mapper.insert(c);
    }

    @Override
    public int delete(String num) {
        return mapper.delete(num);
    }

    @Override
    public int update(Customer c) {
        return mapper.update(c);
    }
}
