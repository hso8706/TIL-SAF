# MYSQL
### Index
1. RDBMS & SQL
2. DML(SELECT)
3. SET Operation

## RDBMS & SQL
### RDBMS
- 의미 및 특징
  - 관계형 데이터베이스 시스템
  - 테이블 기반 구조

### SQL
- 의미 및 특징
  - DB에 있는 정보를 사용할 수 있도록 지원하는 언어
  - 모든 DBMS에서 사용 가능한 표준어
- SQL 구문 종류
  - DML : Data Manipulation Language
    - SELECT, INSERT, UPDATE, DELETE
    - 데이터 조작어, 테이블의 Records를 조작함(CRUD)
  - DDL : Data Definition Language
    - CREATE, ALTER, DROP, RENAME
    - 데이터 정의어, DB 객체의 구조를 정의
  - DCL : Data Control Language(접근 권한 변경)
    - GRANT, REVOKE
    - 데이터 제어어, DB나 Table의 접근권한이나 CRUD 권한을 정의
  - TCL : Transaction Control Language
    - COMMIT, ROLLBACK

## DML(SELECT)
### SELECT
- select 사용 기본 구조
    ```mysql
    select id, name
    from city;
    // city(table)에서 id, name에 해당하는 column의 데이터를 모두 호출
    ```
- `,`
  - select로 선택하는 column들을 구분할 때 사용하는 키워드
  - 다중 컬럼을 선택할 수 있다.
- `from`
  - 어떤 table을 사용할 지 설정하는 키워드
  - 쿼리문 중에서 가장 첫번째 우선 순위로 실행된다.
- `*`
  - select 시 모든 column을 선택하는 키워드
- `all`
  - 선택한 column의 모든 값을 가져오는 키워드, 생략해도 무관한 듯 하다.
- `distinct`
  - 중복된 값은 호출하지 않게 설정하는 키워드
- `+, -, *, /` 사칙 연산
  - 선택된 column의 데이터를 호출함과 동시에 연산을 할 수 있는 키워드
  - 해당 키워드를 사용하면 `column + 사칙연산`의 이름으로 된 column이 새로 생성 및 호출되며, 그 결과는 연산된 결과가 호출된다.
  - 키워드를 사용한 데이터가 숫자형이 아니라면 0이 기본값으로 지정된 상태로 연산된 결과가 호출된다.
- `alias`
  - column을 호출할 때 별칭을 지어 새로운 이름의 column으로 호출하는 키워드
  - 주로 새로운 결과(예. 연산된 결과)를 호출할 때 alias를 주로 사용한다.
  - alias 사용 가능 예시, 3종류
  ```mysql
  select id + 1 별칭, id + 1 "별칭", id + 1 as 별칭
  from city;
  //3개의 컬럼을 호출하고, 컬럼의 이름은 모두 `별칭`이다.
  ```
- `NULL Value`
- `case when ~ then else`
  - 자바의 switch ~ case 문과 같이 범위를 구분하여 특정 범위 조건에 해당하는 데이터를 호출하는 조건 키워드
  - `case` : 조건문을 여는 키워드
  - `when` : 실질적인 범위 조건을 설정하는 키워드
  - `then` : when 키워드와 1대1 대응되는 키워드로, 해당 범위 조건으로 호출되는 column의 alias를 설정하는 키워드
  - `end` : 모든 when 범위 조건에 해당되지 않는 기본 값들을 모아서 호출되는 column의 alias를 설정하는 키워드

### Select where
- `where + 조건`
  - 쿼리 조건문
  - 쿼리문 중에서 2번째 우선 순위로 실행된다.
- `and, or`
  - 다중 조건을 걸기위해 사용
- `not`
  - `not + 조건`이나 `!`로 표현하며, 해당 조건의 반대의 경우를 표현할 때 사용
- `in, not in`
  - 조건문을 특정 범위 내로 한정하거나 특정 범위 외로 한정 할 때 사용하는 키워드
  - `in, not in`키워드 뒤에는 `select`로 불러오는 데이터와 대응되는 값들이 있는 범위여야 한다.
  - 예시
  ```mysql
  select id
  from city
  where id in (10, 11, 12, 13, 14, 100);
  ```
- `between`
  - 조건문을 특정 범위 내로 한정할 때 사용하는 키워드
  - `in`과 다른 점은 대응되는 값의 범위를 일일이 지정하는게 아닌 부등호로 지정하듯 범위를 지정할 수 있다는 점이다.
- `is null, is not null`
  - where 조건문에서 조건으로 null 값을 체크하는 키워드
- `like`
  - where 조건문의 조건으로 정확히 일치하는 값이 아닌 비슷한 값을 호출하기 위해 사용하는 키워드
  - 정규표현식을 사용
  - `%`: 해당 위치에 0개 이상의 문자가 온다. 0일수도 있기 때문에 안와도 그만
  - `_`: 해당 언더바만큼 문자가 존재한다. 문자열에서 문자 위치를 표현할 때 주로 사용

### Select 논리 연산
- not 연산
  - true -> false
  - false -> true
  - null -> null
- and 연산
  - true, true 일 때만 결과가 true, 나머진 false
  - 특히, false가 첫 항으로 나오면 뒤는 보지도 않음. (두번째 항에 null이 오는 상황에도 적용)
  - null이 포함된 논리 연산
    - true & null || null & true || null & null == null
    - false & null || null & false == false
- false 연산
  - 하나만 true여도 모두 true, false or flase 일 때만 false 결과가 나온다.
  - 첫 항이 true면, 뒤도 안보고 true가 된다. (두번째 항에 null이 오는 상황에도 적용)
  - null이 포함된 논리 연산
    - true & null || null & true == true
    - false or null || null or false || null or null == null

### Select Order by
- `order by 컬럼명 정렬방식`
  - 해당 컬럼을 오름차순(asc), 내림차순(desc) 정렬하는 키워드
  - 쿼리문 전체에서 가장 마지막 우선순위로 실행된다.

## SET Operation