package com.jdbc.customer;

import java.util.List;

public interface CustomerService {

	List<Customer> selectAll();//all data
	Customer findByNum(int num);//num에 해당하는 레코드 1건
	List<Customer> findByName(String name);//like 검색
	List<Customer> findByAddress(String address);//주소 그냥 검색
	
	int add(Customer p); // 새로운 고객 추가
	int delete(int num); // 고객 삭제(회원 탈퇴)
	int update(int num, String address);//번호기준으로 주소 변경	
}
