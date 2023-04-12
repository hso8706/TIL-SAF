# 23.04.12

### SQL 명령어 구분
- DML, DDL, TCL, DCL
- 이번 DB 학습에선 DDL 위주로 배울 에정

## DDL

### DDL 정의
- DB 객체의 구조를 정의
- 테이블 생성, 컬럼 추가, 타입 변경, 제약조건 지정, 수정 등

### DDL 종류
- CREATE : DB 객체 생성, create으로 생성한 것은 항상 drop으로 삭제 가능(짝꿍)
- DROP : DB 객체 삭제
- ALTER : 기존 DB 객체 수정

### TABLE 생성
    ```mysql
    create table (table_name) {
        (column_name1) (column_type) (제약 조건, optional attributes)
        (column_name2) (column_type)
    }
    ```
### Optional attributes, 제약 조건
- table 생성 시, column에 거는 조건
  - not null
  - default value
  - auto increment
  - primary key : 중복과 null 모두 불가능
  - forien key : 참조값(외래키), null 가능
  - unique : 중복은 불가하지만 null은 가능
  - ...
  
### column_type
- 문자형
  - char
    - 고정 길이를 갖는 문자열
    - char(20)이라면, 20자만큼의 저장 공간을 무조건 차지
  - varchar
    - 가변 길이를 갖는 문자열
    - varchar(20)인데 10자 만큼 사용했다면, 10자만큼의 저장 공간을 차지
- 숫자형
  - int : 정수형, 굳이 size를 인자로 제공하지 않아도 된다.
  - real : 
  - decimal : 전체 자릿수와 소수점 밑 제한 개수를 인자로 제공
- 날짜형
  - datetime
  - timestamp
    - 이거 쓰라고 말해주심, index가 더 빠르게 생성된다고 함
- 이진 데이터 타입
  - binary
    - 이미지 같은 걸 경로가 아닌 직접 이미지를 넣는 경우에 사용할 수 있다.
  - blob
    - 보통 많이 씀, binary large object

### 참조 테이블
- 참조되는 테이블: 부모 테이블
- 참조하는 테이블: 자식 테이블

### forein key
- data insert 상황
  - 부모 테이블 먼저 insert 하고, 이후 자식 테이블에 insert 한다.
- data delete 상황
  - 자식 테이블 먼저 delete 하고, 이후 부모 테이블에서 delete 한다.
- 게시판의 글과 댓글의 관계를 예시로 생각

### cascade
- cascade : 연쇄적으로, 계단을 흘러내려가듯
- on delete cascade
  - delete 하는 상황일 때, 원래는 부모 테이블 데이터부터 삭제할 수 없는데 해당 키워드를 사용하면 가능하다.
  - 부모 테이블을 삭제하면서 관련된 자식 테이블의 정보를 삭제한다.

### key(pk, fk)의 의의
- data의 무결성, 즉 잘못된 데이터의 허용을 방지하기 위함

### index
- data를 조회할 때, 조회 동작 속도를 높여주기 위해 사용하는 자료구조
- index가 없다면 완탐을 해야한다.
- column의 값과 레코드가 저장된 주소를 키와 값의 쌍으로 저장
- index는 메모리 낭비로 이어질 수 있기 때문에 데이터 양이 많을떄 주로 사용
- index가 자주 변경되는 경우에도 낭비로 이어질 수 있음.

### Index 활용
- data가 많은 경우
- 조회가 많이 되는 컬럼에 지정
- 삽입/삭제가 적은 경우
- join 시 자주 사용되는 컬럼
- cardinality가 높은 컬럼; 한 컬럼에 들어가는 값의 종류가 다양할 수록 cardinality가 높다고 본다
  - 예시. 성별 컬럼은 cardinality가 낮은 편이다.
- => where 절에 자주 사용되는 컬럼

### Index 생성 전략
- FK, PK로 설정한 열에는 자동으로 Index가 생성됨.
- 위의 Index 활용에 유리한 경우들에서 Index를 사용하는 것이 좋다.
- 클러스터형 인덱스는 테이블당 하나만 생성할 수 있다.
  - 클러스터형 인덱스: PK에 지정된 index, 테이블 당 1개만 생성됨
  - 이를 clustered index라고 하며, 반대되는 개념으로 nonclustered index(secondary index)라고한다.
  - 클러스터형 인덱스는 자동 생성된다.
  - PK가 없으면 unique이면서 not null인 첫번째 컬럼이 클러스터형 인덱스가 된다.
  - 클러스터형 인덱스가 생성되면, 클러스터형 인덱스는 특별히 물리적으로도 자료가 정리된다
  - unique만 있어도 억지로 인덱스를 만들긴함
  - 근데 unique조차도 없으면? mysql이 몰래 내부적으로 column을 따로 만듬. 이 때 가상 클러스트형 인덱스는 `Gen_cluster_index_rowid`이고 값은 insert 순서이다.
- //index_type인 BTREE 알아보기

### index 관련 명령어 
- show index from table_name;
  
## View
### View 란?
- DB에 존재하는 가상의 테이블을 `View`라고 한다
- DB의 테이블의 일부를 가상으로 만들어둔 것
- View에는 SQL만 저장되고 실질적인 데이터를 담는 테이블이 있는 것은 아니다.
### View의 장점
- 특정 사용자에게 테이블 전체가 아닌 필요한 필드만 보여줄 수 있다.(보안성)
- 복잡한 쿼리를 단순화할 수 있다
- 쿼리를 재사용할 수 있다.
### View의 단점
- 삽입, 삭제, 갱신 작업에 제한이 있음
### View 종류
- 단순 뷰
- 복합 뷰
- 인라인 뷰
  - 일반적으로 가장 많이 사용
  - from 절 안에 sql 문장이 들어가는 것을 인라인 뷰라고 한다.