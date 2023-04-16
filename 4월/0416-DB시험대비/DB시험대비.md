# 23.04.13
## DB 시험 대비

### View
- 생성
  - `create [view_name] as`+ {select 문}
- 조회
  - `select [col_name] from [view_name]`
- select 하는 방법
  - 그냥 table에서 하던 형식과 똑같음
  - show 키워드는 index 볼 때 사용함. 착각 주의

### PK, FK
- PK, FK를 사용하는 이유
  - 데이터의 무결성을 위해서
  - 잘못된 데이터의 저장을 방지하기 위해서
- 클러스터형 인덱스랑 같이 기억

### Clustered Index
- 테이블 당 하나만 생성할 수 있는 인덱스
- MySQL: 1) PK 지정 컬럼, 2) unique + not null 3) unique 4) 임의의 가상 컬럼 생성(Gen_cluster_index_rowid)
- PK를 설정하면 해당 column에는 클러스형 인덱스가 자동 생성된다.
- 일반 인덱스와는 다르게 클러스터형 인덱스는 저장된 순서를 물리적으로 정렬하는 방식을 지닌다
  - 때문에 조회가 굉장히 빠르다
  - 하지만 수정, 추가, 삭제가 느리다

### SubQuery
- MainQuery 내부에 존재하는 InnerQuery를 SubQuery라고한다.
- SubQuery의 결과를 받아내는 키워드
  - 단일행 결과 반환인 경우: = 키워드 사용(in도 가능)
  - 다중행 결과 반환인 경우: in 키워드 사용

### Join
- join의 종류
  - inner join
    - 공통 컬럼(교집합)을 기준으로하는 join
    - 공통 컬럼이 필수적으로 존재해야 inner join을 사용할 수 있음
  - outer join
    - 공통된 컬럼이 없는 경우에도 join을 사용하기 위한 join 방법(공통 컬럼이 없다면 가상의 컬럼을 생성한다.)
    - 두 테이블을 조인할 때, 한 쪽 레코드에 null 값이 존재해서 누락될 경우를 방지하기 위해 사용하는 join
    - left outer join, right outer join
    - full outer join 방식도 존재하지만 mysql은 지원하지 않는 기능
      - 양쪽 테이블에 필요한 부분을 알아서 채워가며 가상의 레코드를 생성하는 join
  - self join
    - 자기 자신을 또 다른 테이블로 취급하여 스스로를 참조하는 join 방식
- join을 사용하기위한 문법
  - where ~
    - 일반적으로 조인 조건을 포함하기 위해 사용
  - join ~ on
    - join 키워드를 쓴다면 where이 아닌 on을 사용
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

### Subquery
- 쿼리(main query)문 내에 다른 쿼리문이 포함되어 있는 경우에, 포함된 쿼리를 subquery라고 부름

### Subquery의 종류
- 중첩 서브 쿼리(Nested Subquery) : where 문에 작성
- 인라인 뷰(Inline view) : from 문에 작성
- 스칼라 서브 쿼리(Scalar Subquery) : select 문에 작성
- 
### inline view
- from 절에서 사용하는 서브쿼리
- 데이터베이스에 저장 못함(일회성)
- 동적으로 생성된 테이블이기 때문에 column을 자유롭게 참조할 수 있다.

### 서브쿼리를 사용할 수 있는 곳
- select
- from
- where
- having
- order by
- insert문의 values
- update문의 set
- 대부분의 문법에서 가능, 안되는 경우는 특정 상황정도가 있음

### create - drop 짝꿍
- create으로 만든 것은 다 drop으로 삭제할 수 있음
- `create ~~~`로 만든 쿼리문을 제시하고 어떤 쿼리문으로 삭제할 수 있을지 보기 주어질 듯

### group by
- having : group에 조건을 걸 때, 사용하는 키워드
- group by 할 때 다중 컬럼을 반환하는지, 단일 컬럼을 반환하는지 주의할 것
  - 단일 컬럼을 반환하는 경우에는 다중 결과를 select하는 부분이 없어야한다.

### pk, fk 지정 방법 종류
- inline
  - table 생성 쿼리문의 컬럼 생성 쿼리문에 같이 작성
  - col_name col_type primary key;
- outline
  - table 생성 쿼리문의 마지막에 따로 작성
  - create table table_name {... primary key(col_name)};
- alter 키워드
  - table 생성이 끝난 후 table 값을 변경하는 alter 쿼리문으로 pk, fk를 지정

### alter 키워드를 통한 pk, fk 지정
- `alter table test add constraint test_pk primary key(id);`
  - test : table 명
  - test_pk : PK로 지정할 때 붙이는 이름(별칭)
  - id : pk로 지정할 column 명

### use database db이름
- 생성되어있는 DB를 사용하는 쿼리문

### view, index
- view란?
  - 
- index란?
  - 테이블에 대한 동작 속도를 높여주는 자료 구조(DB 분야 한정)
    - 인덱스가 없다면 조회를 위해서 항상 완탐
  - key, value로 이루어져 있다.
    - (key : value) == (컬럼의 값 : 레코드의 주소)
  - 인덱스는 데이터베이스에 따로 저장될 공간이 필요함
    - 메모리 낭비를 초래할 수 있음
    - 조회를 빠르게 돕지만, 추가, 삭제, 변경에는 오히려 악영향을 끼칠 수 있으므로 인덱스가 유리한 상황에만 사용하는 것이 좋음

### index 생성 전략
- column 단위에 생성
- where 절에서 사용되는 column에 생성
  - == 조회로 자주 쓰이는 column
- join이 자주 사용되는 column에는 생성하는 것이 좋음
- 데이터의 조회는 많고, 변경은 적은 곳에 생성하는 것이 좋음
- 사용하지 않는 index는 삭제
- cardinality가 높은 컬럼
  - 한 컬럼에 들어가는 값의 종류가 다양할 수록 cardinality가 높다고 본다(예. 성별 컬럼은 cardinality가 낮음)


### like 검색; 무조건 나오나봄 ㅋㅋ
- where fname like '%A%' : 중간에 A가 들어가는거 검색 
- where fname like '%A_' : 끝에서 두번째가 A인 레코드 검색 

### DB modeling
- 어떤 데이터가 존재하고 필요한 지 정리하거나 분석하는 방법을 의미함

### DB 모델링 순서
- 개념적 모델링
  - 업무 프로세스 => 개념적 구조(ERD 생성)
- 논리적 모델링
  - 개념적 구조 => 데이터 모델(Schema 생성)
- 물리적 모델링
  - 데이터 모델 => 물리적 데이터베이스(tool을 이용하여 실제 DB 생성)

### ERD; Entity Relationship Diagram
- Entity
  - 여러 data를 가지고 있고, 명사형으로 명명
  - 네모
- Attribute
  - 속성, key 표시
  - 동그라미
- Relationship
  - Entity와 Entity 관계
  - 마름모