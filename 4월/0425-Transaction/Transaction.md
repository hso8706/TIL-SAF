# 23.04.25
### 라이브러리와 프레임워크
### 지난 리뷰
- Lombok
- Mapper
  - dao를 대신함
- 흐름 정리
  - client 요청
  - Dispatcher Servlet
  - Controller
  - Service(ServiceImpl)
  - Mapper(MapperProxy)
- MapperScannerConfigurer
  - Mapper의 위치를 파악하고, Mapper의 프록시를 만들어주는애
- Mapper File
  - Query가 들어있는 file(.xml)
  - Query마다 id가 존재
  - 해당 id는 Mapper.java의 메소드명과 일치해야한다.
- SqlSessionFactoryBuilder(SqlSessionFactoryBean)
- SqlSessionFactory
- SqlSession
### Transaction 
- insert, update, delete의 경우 트랜잭션 관리를 하는 것이 좋음
### Transaction Manager
- 여러 종류의 매니저가 존재
- `JDBC`을 직접 쓰거나 `MyBatis`로 database를 이용하는 경우에는 `DataSourceTransactionManager` 사용
- tx 관리는 Service에서 관리
### @Transaction
- 해당 애너테이션이 붙은 service의 메소드는 transaction으로 관리된다.
### 동적 SQL (dynamic query)
- sql문이 실행될 때 조건에 따라 다르게 실행되게 한 쿼리
- 조건 종류
  - if
  - choose (when, otherwise)
  - trim (where, set)
  - foreach
### myBatisAppTest
- dynamic query 연습(Customer.xml)
- 서비스 객체에서 로직으로 해결하는 것보다 쿼리로 해결할 수 있으면 더 좋음. 쿼리를 잘해야 몸값이 오른다
- `#`과 `$`의 차이
  - `#`이 보안상 유리함(sql injection)