package com.jdbc.customer;

import java.util.List;
// client (customerTest.java)에게 제공하기 위한 목적
public interface CustomerService {

	List<Customer> selectAll();//all data
	Customer findByNum(String num); //num 에 해당하는 레코드 1건
	List<Customer> findByName(String name);//이름으로 검색, like
	List<Customer> findByAddress(String address); //주소로 검색
	
	int add(Customer p); //새로운 고객 추가
	int delete(int num); // 고객 삭제
	int update(int num, String address);//번호기준 주소 변경	
}
