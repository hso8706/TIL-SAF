# MYSQL
### Index
1. Group By Clause
2. DML(insert, update, delete)
3. Transaction
   
## Group By Clause
### group by 절
- 의미 및 특징
  - select 문에 단일행 반환 함수(집계 함수)와 다중행 반환 함수가 함께 사용된 경우에 사용하는 키워드
  - 다중행에 대한 쿼리 데이터와 단일행에 대한 쿼리 데이터를 그룹핑한다.

### 쿼리문 최종 실행 순서
```mysql
select      //5
from        //1
where       //2
group by    //3
having      //4
order by    //6

//1: 어떤 테이블에서
//2: 어떤 조건으로
//3: 필요하면 그룹핑을 해서
//4: 그룹핑은 어떤 조건으로
//5: 1~4를 거친 데이터 중 어떤 것들을 반환할 것인지
//6: 반환 후 정렬을 어떻게 할 것인지.
```
## Having Cluase
### havung 절
- 의미 및 특징
  - group by한 결과에 조건을 추가할 경우 having 절 사용
  - where이 group by보다 먼저 실행되기 때문에 where로는 group by에 대한 조건을 줄 수 없음을 주의

### 최종 쿼리문 예시
```mysql
select job_id, avg(salary)          //5
from employees                      //1
where department_id in (40, 50, 80) //2
group by job_id                     //3
having sum(salary) > 50000          //4
order by avg(salary) desc;          //6

//1 : employees 테이블에서
//2 : department_id가 40, 50, 80에 해당하는 records들에서만 뽑을 거야
//3 : 그전에 job_id는 그룹핑하고
//4 : 그룹핑할때 sum(salary)가 50000 이상인 job_id만 그룹핑할거야
//5 : 3,4에서 그룹핑한 job_id 그룹들을 반환하고, 동시에 각 job_id 그룹의 avg(salary)도 반환해
//6 : 반활할 때는 avg(salary)의 결과를 내림차순으로 정렬하면서 반환해.
```

## DML, Data Manipluation Language
### DML CRUD
- insert(C)
- select(R)
- update(U)
- delete(D)

### INSERT
- 의미 및 특징
  - 특정 테이블을 지정하고, 해당 테이블에서 원하는 column에 데이터 값을 추가하는 키워드
  - `into` 키워드와 함께 사용한다.
  - 해당 테이블의 전체 컬럼에 데이터를 넣는 경우는 데이터를 넣을 컬럼명을 생략해도 된다.
  - default 값이 설정되어 있거나, null이 허용되는 컬럼에는 데이터 값 추가를 생략해도 된다.
  - auto increment가 설정된 컬럼에는 데이터 값 추가를 생략해도 된다.
  - 다중 records를 추가할 땐 콤마(,)로 구분한다.
- 기본 구조
```mysql
insert into table_name (col_name1, col_name2, ..., col_nameN)
values (col_val1, col_val2, ..., col_valN)
```

### UPDATE
- 의미 및 특징
  - 특정 테이블을 지정하고, 해당 테이블에서 원하는 column의 데이터를 수정하는 키워드
  - `set` 키워드와 함께 사용한다.
  - 여러 컬럼의 데이터를 변경할 경우 콤마(,)로 구분한다.
  - where 조건문을 주지 않을 경우, 해당 테이블의 모든 데이터가 변경될 수 있으니 주의해야한다.
- 기본 구조
```mysql
update table_name
set col_name1 = col_val1, ..., col_nameN = col_valN
where conditions;
```

### DELETE
- 의미 및 특징
  - 특정 테이블을 지정하고, 해당 테이블에서 원하는 데이터를 삭제하는 키워드
  - where 조건문을 주지 않을 경우, 해당 테이블의 모든 데이터가 삭제될 수 있으니 주의해야한다.
- 기본 구조
```mysql
delete from table_name
where conditions;
```
- 예시
```mysql
delete from member
where username = '홍길동';
// username이 홍길동인 사람의 데이터 삭제
```

## MYSQL Transaction
### Transaction
- 의미 및 특징
  - 데이터베이스의 상태를 변화시키는 작업 그룹의 최소 단위
- 키워드
  - `start transaction`
    - 트랜잭션의 시작을 알리는 키워드
    - `commit`이나 `rollback` 키워드가 나올 때까지 트랜잭션을 이어감
  - `commit`
    - `start transaction`부터 `commit`까지의 쿼리를 실행시키는 키워드
    - 하나의 트랜잭션이 종료되는 부분
  - `rollback`
    - `start transaction`부터 `rollback`까지의 쿼리를 취소하는 키워드 => 트랜잭션 시작 전 상태로 되돌림.
    - 하나의 트랜잭션이 종료되는 부분
  - `savepoint point_name`
    - 특정 포인트를 지정하는 키워드
    - `commit to point_name` 혹은 `rollback to point_name`으로 사용 => 해당 지점에서 트랜잭션 종료