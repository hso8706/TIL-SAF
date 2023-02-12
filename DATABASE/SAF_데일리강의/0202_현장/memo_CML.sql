-- table creations & constraint(제약조건)
-- create table
create table test1(id int(3) primary key,
name varchar(10) not null,
email varchar(20) unique); -- unique: 중복 불가, null 가능
-- primary key(PK)
-- : null, 중복 값이 올 수 없음.
-- foreign key(FK); 참조키
-- : 다른 테이블의 키를 참조하는 컬럼. 혹은 자기 자신 테이블의 키를 참조해도 가능
-- : 다른 테이블의 unique인 것도 참조할 수 있다.
-- : null, 중복 값이 올 수 있음.
-- : 다른 테이블 내에 없는 키를 쓰려하면 에러가 난다.
-- 참조 관계
-- 부모 테이블 : 참조되는 테이블
-- 자식 테이블 : 참조하는 테이블
-- 두 테이블에 모두 연관있는 데이터가 insert 될 땐 부모 테이블 먼저, 삭제할 땐 자식 테이블 먼저 삭제(당연)

-- 테이블이 만들어진 후 변경 => alter table
-- PK 지정 추가
alter table emp -- table 변경
add constraint emp_pk primary key(empid); -- 제약조건(contraint)을 추가하면서 변경, empid를 pk로 등록하며 emp_pk로 명명(명명된 이름은 이후 제약조건 수정 시 사용)
-- add constraint emp_pk primary key(empid, email); -- 복합키 설정, 두 개를 묶어서 pk로 삼음

alter table dept
add constraint dept_pk primary key(deptid);

alter table loc
add constraint loc_pk primary key(locid);

alter table job
add constraint job_pk primary key(jobid);

-- FK 지정 추가
-- emp(deptid) -> dept(deptid)
-- emp 테이블의 deptid 컬럼을 fk로 지정
alter table emp
add constraint emp_deptid_fk foreign key(deptid)
references dept(deptid); -- foreign key 지정할 땐 확실하게 참조한다는 것을 명시

alter table emp
add constraint emp_loc_fk foreign key(locid)
references loc(locid);

alter table emp
add constraint emp_jobid_fk foreign key(jobid)
references job(jobid);

-- inset into {table_name} values();
select * from test1;
insert into test1 values(1, 'tommy', 'tommy@me.com');
insert into test1 values(2, 'jane', 'jane@me.com');

-- drop table
drop table test1; -- table 완전 삭제(data도 삭제)

-- create table_new example
create table test1(id int(3) primary key,
name varchar(10) not null,
address varchar(30),
email varchar(20) unique);

select * from test1;
insert into test1 values(1, 'jane', 'seoul', 'jane@me.com'); -- 사실 테이블 뒤에 컬럼명이 생략된 것임!
-- 특정 컬럼만 insert하기
insert into test1(id, name, email) values(2, 'tom', 'tom@me.com');
insert into test1 values(3, 'kim', 'la', 'kim@me.com');

-- update {table_name} set {column_name}
update test1
set address = 'london'
where id =1; -- where 절 필수! 그렇지 않으면, 해당 컬럼내의 모든 데이터가 변경된다

update test1
set address = 'paris', email = 'abc@me.com'
where id = 2;

-- delete
delete from test1
where id = 3; -- delete 또한 where 절이 필수! 아니면 다 삭제된다.