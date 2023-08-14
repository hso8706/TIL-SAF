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

## Error 2

### 상황
- AWS RDS 연결이 어떤 곳에선 되는데 어떤 곳에선 안되는 문제
- 에러 코드
  - 연결 불가, connection time out 같은 메세지가 뜸

### 원인
- 인바운드 규칙에서 IP 허용 파트가 개인 PC만 허용되어있었기 때문

### 해결
- RDS 콘솔 접속
- 데이터베이스 탭
- 연결 & 보안 탭 - `보안` 부분에 활성화 되어있는 보안 그룹 클릭
- 이동한 페이지에서 인바운드 규칙 탭 클릭
- 인바운드 규칙 편집 버튼 클릭
  - 보안 그룹 규칙 ID
  - 유형: MYSQL/Aurora
  - 프로토콜: TCP (고정)
  - 포트 범위: 3306 (고정)
  - 소스: 사용자 정의 선택
  - 돋보기 버튼에서 0.0.0.0/0
  - 규칙 저장

## Error 3

### 상황
- 한글 데이터가 들어가지 않는 상황
  - null, 영어 데이터는 들어가는데 한글 데이터는 아예 접근 조차 안되는 문제

### 원인
- Maria DB 문제
- 기본 character set에 utf-8로 되어있지 않음

### 해결
- 참고 링크(aws rds에서 변경)
  - https://twofootdog.tistory.com/62
- local database(예. mysql workbench)에 접속해서 명령어로 변경하기
- ddl-auto 옵션을 create, create-drop으로 해서 새로 데이터베이스가 초기화 되도록 해야지 적용됨