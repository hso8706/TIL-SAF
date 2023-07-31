## Error 1
### 상황
- AWS RDS 연결
  - local mysql client에서는 문제없이 연결됨.
  - 하지만 jpa에서는 database를 찾지 못하는 것 같다는 에러 코드를 발견함.
- 에러 코드
    ```
    Caused by: org.h2.jdbc.JdbcSQLSyntaxErrorException: Table "USER_ROLES" not found (this database is empty); SQL statement:
    ```
  - 위 에러 코드를 보면 h2에 연결된 것이 확인됨.
  - h2는 spring boot 실행 시 기본값으로 연결되는 데이터베이스
  - 즉, aws rds를 연결하지 못한 것.
  - 또 다른 문제
    - h2 에 연결되어있으면 ddl-auto: create는 돼야하는데, 아예 db, table 자체를 못 찾는 것도 이상했음.
    - 그 이유는 연결은 h2에 연결되어있는데 jpa.database-platfrom의 dialect는 mariaDB였기 때문에 발생했던 문제라고 생각함

### 해결
- gradle 필요
    ```
    // MariaDB 데이터베이스 드라이버 추가
    implementation 'org.mariadb.jdbc:mariadb-java-client:2.7.3'
    ```
- yml 파일 들여쓰기 중요
  - 가장 문제가 된 부분은 `datasource` 부분
  - `datasource`는 `spring`의 바로 하위 레벨이어야 한다...
