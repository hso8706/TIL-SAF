# 23.04.13
## DB 시험 대비

### View
- select 하는 방법
  - 그냥 table에서 하던 형식과 똑같음
  - show 키워드는 index 볼 때 사용함. 착각 주의

### PK, FK
- PK, FK를 사용하는 이유
  - 데이터의 무결성을 위해서
  - 잘못된 데이터의 저장을 방지하기 위해서

### SubQuery
- MainQuery 내부에 존재하는 InnerQuery를 SubQuery라고한다.
- SubQuery의 결과
  - 단일행 : = 키워드 사용(in도 가능)
  - 다중행 : in 키워드 사용

### Join
- join의 종류
  - inner join
    - 공통 컬럼을 가지고하는 join
  - outer join
  - self join
- join을 사용하기위한 문법
  - where ~
  - join ~ on
  - join ~ using
    - 양 쪽 테이블에 똑같은 이름의 공통 컬럼이 있을때 사용
    - 해당 컬럼에는 테이블의 별칭을 붙이지 않음
  - 특정 상황을 나누긴 했지만, 그냥 다 쓸 수 있음
    - 같은 내용을 다른 문법의 join으로 표현하는 것 연습

### 서브쿼리 주의사항 및 조건
- 비교 연산자의 오른쪽에 기술
- 반드시 소괄호로 감싸져 있어야 한다.

### SQL 구분
- DDL
  - create, drop, alter
- DML(CRUD 작업에 사용)
  - insert, delete, update, select
- DCL
  - grand, revoke
- TCL
  - commit, rollback

### outer join
- left join
- outer join
  - 두 테이블을 조인할 때, 한 쪽 레코드에 null 값이 존재해서 누락될 경우를 방지하기 위해 사용하는 join
- full join => mysql에선 지원하지 않음
  - outer join은 한 쪽을 기준으로 가상의 레코드를 만드는 것이지만, full join은 양쪽에 알아서 필요한 부분을 찾아서 가상의 레코드를 만들어주는 join 방식

### inline view
- from 절에서 사용하는 서브쿼리
- 데이터베이스에 저장 못함(일회성)
- 동적으로 생성된 테이블이기 때문에 column을 자유롭게 참조할 수 있다.

### 서브쿼리를 사용할 수 있는 곳
- pdf 참고

### create - drop 짝꿍
- create으로 만든 것은 다 drop으로 삭제할 수 있음

### group by
- having : group에 조건을 걸 때, 사용하는 키워드
- group by 할 때 다중 컬럼을 반환하는지, 단일 컬럼을 반환하는지 주의할 것

### alter 키워드를 통한 pk, fk 지정

### 자동 생성 인덱스
- cluested index
  - pk, fk, unique로 지정한 컬럼에 자동 생성
  - 우선 순위 pk > fk > unique (?)

### use database db이름

### view
- view란?
- index란?

### like 검색; 무조건 나오나봄 ㅋㅋ
- where fname like '%A%' : 중간에 A가 들어가는거 검색 
- where fname like '%A_' : 끝에서 두번째가 A인 레코드 검색 

### DB modeling

### 개논물