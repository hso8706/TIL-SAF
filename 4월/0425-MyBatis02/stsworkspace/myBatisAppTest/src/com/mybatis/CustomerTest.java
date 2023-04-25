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
        String conf = "res/Configuration.xml";//mybatis ���� ����(1.typeAlias(vo), 2. DB Pool ���� 3. Mapper file(sql))
        Reader reader; // �Է� ������

        try {
        	//Resources Ŭ������ Ŭ���� �н��� ���� �ý���, �� url�κ��� �ڿ��� �ε��ϵ��� �����ִ� ��ü
            reader = Resources.getResourceAsReader(conf);//Configuration.xml
            
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(reader);
//            SqlSession session = factory.openSession();//SqlSession: CRUD �޼ҵ� ������ ����
            SqlSession session = factory.openSession(true);//true: autocommit ���� ���, ������ ���� ���� ��� �ڵ� ����
          
            //1.selectList(): ���ϰ��� �������� ���
//            List<Customer> list = session.selectList("selectAll");
            List<Customer> list = session.selectList("join");
            for (Customer c : list) {
            	System.out.println(c);
            }
            
            System.out.println("------------------------");
            //2. selectOne: ���ϰ��� �� ���� ���
            Customer c= session.selectOne("selectOne", "111");//1�� ����: ������ ���� id, 2�� ����: ���� �Ķ����
            System.out.println(c);
            
            //3. insert
            c = new Customer("999", "Genie", "la");
            int x = session.insert("insert", c);
            System.out.println(x); //��� 1: �μ�Ʈ ���� ����
//            session.commit(); //������ db�� �۾� ����  
            
            //4. delete
            int y = session.delete("delete", "999");
            System.out.println(y);
            
            //5. 111�� ���ڵ��� �ּҸ� 'moscow'�� ����
            // java �ڵ�� update(setter) �� db ����
            Customer z = session.selectOne("selectOne", "111");
            z.setAddress("moscow");
            session.update("update", z);
            
            //6. 
            
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
