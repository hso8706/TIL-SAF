# 23.04.24
### MyBatis
- DB Framework
- ORM Framework의 종류
  - Object: java 객체(VO)
  - Relation: table(records)
  - Mapping: Object와 Relation이 1:1로 짝을 이룸
  - Mapping을 자동으로 해주는 Framework
    - 자바 객체를 만들면 자동으로 insert, 만든 객체를 null로 바꾸면 자동으로 delete
- SQL Mapper 라고도 부름

### 기존과 MyBatis의 차이
- 기존 DaoImpl
  - java code + DB 정보(환경 정보) + SQL 문
  - 짬뽕
- MyBatis 사용
  - java code
  - Mapper file(query xml)
  - DB 정보(xml 설정 파일)
  - 모두 분리

### MyBatis 사용
- jdbc
  - driver, connection, ... 필요
- mybatis
  - mybatis가 제공하는 메서드만 사용
  - 위 jdbc 과정은 메서드 내부에서 자동 실행

### SqlSessionFactory
- SqlSession
  - Connection
  - CRUD method를 가지고 있음
- SqlSessionFactory
  - SqlSession 존재
  - SqlSession 공장
- SqlSessionFactoryBuilder
  - SqlSessionFactory을 만드는 애
  - new 키워드 사용

### 쿼리문의 중복
- namespace를 붙여준다.

## SprignMVCBoardMyBatis
### BoardMapper.xml
- src/main/resources/mapper
- CPXAC 위치

### ServiceImpl에 Proxy 객체 주입
### Mapper.java와 Mapper.xml
- Mapper.java에 있는 메서드명과 Mapper.xml에 있는 id명이 일치해야 실행이 된다.
### Mapper.xml의 조건
- Mapper.java와 짝을 이루어야 함.
  - namespace: Mapper.java의 경로