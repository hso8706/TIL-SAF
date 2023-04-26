package com.mvc.mapper;

import com.mvc.vo.Customer;

import java.util.List;

public interface CustomerMapper {
	public List<Customer> selectAll();
	public Customer selectOne(String num);
	public int insert(Customer c);
	public int delete(String num);	
	public int update(Customer c);
	
}





