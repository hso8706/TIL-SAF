package com.mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerDynamicTest {
	String conf = "res/Configuration.xml";

	public static void main(String[] args) {
		String conf = "res/Configuration.xml";
        Reader reader;

        try {
            reader = Resources.getResourceAsReader(conf);

            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(reader);
            SqlSession session = factory.openSession(true);

            List<Customer> list;
            Map<String, String> map = new HashMap<>();

            //1. selectMore
            map.put("fname", "a");            
//            list = session.selectList("selectMore", map);
            list = session.selectList("selectMore"); //fname == null

            System.out.println(list.size());
            for (Customer customer : list) {
                System.out.println(customer);
            }
            System.out.println("==============================================");
            
            //2. selectMore2
            map.clear();
            map.put("deptid", "40");
//            map.put("jobid", "IT_PROG");
            list = session.selectList("selectMore2", map);
            System.out.println(list.size());
            for (Customer customer : list) {
                System.out.println(customer);
            }
            System.out.println("==============================================");
            
            //3. selectMore3
            map.clear();
            map.put("email", "X");
//            map.put("jobid", "IT_PROG");
            list = session.selectList("selectMore3", map);
            System.out.println(list.size());
            for (Customer c : list) {
                System.out.println(c);
            }
            System.out.println("==============================================");
            
            //4. selectForEach
            int[] dept = {20, 30, 40};
            list = session.selectList("selectForEach", dept);
            System.out.println(list.size());
            for (Customer c : list) {
                System.out.println(c);
            }
            System.out.println("==============================================");
            
            //5. sql
            map.clear();
            map.put("deptid", "60");
            list = session.selectList("qq", map);
            System.out.println(list.size());
            for (Customer c : list) {
                System.out.println(c);
            }
            System.out.println("==============================================");
            
            //6. # or $
            //${} : 파라미터 값만 그대로 전달, #{}: 파라미터에 ''가 붙어서 전달됨
            map.clear();
            map.put("column_list", "empid, fname, deptname");
            map.put("deptid", "60");
            list = session.selectList("ww", map);
            System.out.println(list.size());
            for (Customer c : list) {
                System.out.println(c);
            }
            System.out.println("==============================================");
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
	}

}
