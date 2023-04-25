package com.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class CustomerTest {

    public static void main(String[] args) {
        String conf = "res/Configuration.xml";//mybatis 설정 파일(1.typeAlias(vo), 2. DB Pool 정보 3. Mapper file(sql))
        Reader reader; // 입력 파이프

        try {
        	//Resources 클래스는 클래스 패스나 파일 시스템, 웹 url로부터 자원을 로딩하도록 도와주는 객체
            reader = Resources.getResourceAsReader(conf);//Configuration.xml
            
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(reader);
//            SqlSession session = factory.openSession();//SqlSession: CRUD 메소드 가지고 있음
            SqlSession session = factory.openSession(true);//true: autocommit 설정 기능, 쿼리가 문제 없을 경우 자동 실행
          
            //1.selectList(): 리턴값이 여러개인 경우
//            List<Customer> list = session.selectList("selectAll");
            List<Customer> list = session.selectList("join");
            for (Customer c : list) {
            	System.out.println(c);
            }
            
            System.out.println("------------------------");
            //2. selectOne: 리턴값이 한 개인 경우
            Customer c= session.selectOne("selectOne", "111");//1번 인자: 실행할 쿼리 id, 2번 인자: 쿼리 파라미터
            System.out.println(c);
            
            //3. insert
            c = new Customer("999", "Genie", "la");
            int x = session.insert("insert", c);
            System.out.println(x); //출력 1: 인서트 쿼리 성공
//            session.commit(); //실제로 db에 작업 성공  
            
            //4. delete
            int y = session.delete("delete", "999");
            System.out.println(y);
            
            //5. 111번 레코드의 주소를 'moscow'로 수정
            // java 코드로 update(setter) 후 db 수정
            Customer z = session.selectOne("selectOne", "111");
            z.setAddress("moscow");
            session.update("update", z);
            
            //6. 
            
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
