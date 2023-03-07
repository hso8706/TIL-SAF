# **DB: 데이터 검색**
## Index
1. RDBMS & SQL
2. DML (Select)
3. SET Operation

## RDBMS & SQL
### RDBMS
- 의미 및 특징
  - 관계형 데이터베이스 매니지먼트 시스템
  - 테이블 기반
    - 데이터를 테이블 단위로 관리
    - 하나의 테이블은 여러 개의 Column으로 구성
  - 중복 데이터를 최소화 시킴
    - 같은 데이터가 여러 테이블 혹은 컬럼에 존재할 경우 문제가 발생할 가능성이 있음.
  - 여러 테이블에 퍼진 데이터 검색
    - Join 키워드 사용
- RDBMS 저장 구조
  - Table
  - Column
    - Column Name
  - Row
### SQL
- 의미 및 특징
  - Database에 있는 정보를 사용할 수 있도록 지원하는 언어
  - DB의 표준어(어떤 RDBMS에서든 사용 가능)
  - Query의 대소문자는 구분하지 않음. (데이터의 대소문자는 구분)
  - 대소문자를 구분하는 Query문이 필요할 경우, binary()함수 사용하기(혹은 Mysql 설정 변경)
- SQL 구문
  - DML(Data Mainpulation Language) : 새롭게 입력, 변경, 제거 
    - INSERT(C)
    - SELECT(R)
    - UPDATE(U)
    - DELETE(D)
  - DDL(Data Definition Language) : 데이터를 정의
    - CREATE
    - ALTER
    - DROP
    - RENAME
  - DCL 
