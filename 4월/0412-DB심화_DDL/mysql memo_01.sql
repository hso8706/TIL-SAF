-- db 생성
-- CREATE database `testdb` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ; -- 쿼리로 작성

-- db 사용
use testdb;

-- table 생성
create table test (
id int primary key,
name varchar(20) not null);

-- data insert
insert into test(id, name) values(1, 'tommy');
select * from test;
desc test;

-- table의 column 작업 == table의 수정(alter)
-- col 추가
alter table test add tel varchar(13);
-- col 수정
alter table test modify tel varchar(11);
alter table test modify tel varchar(13);
-- col 삭제
alter table test drop tel;
-- col 이름 변경
alter table test rename column tel to phone;
desc test;

/* key 지정 방식 */
#1. inline 방식으로 만들기 : column 정의 내릴 때, 바로 설정
create table test1 (
id int primary key, /*인라인 방식*/
email varchar(10) unique, /* 중복 x, null 허용*/
name varchar(20));
desc test1;

select * from test1;
insert into test1 values(null, 'ww', 'dd'); -- error: id는 pk이르모 not null
insert into test1 values(1, 'ww', 'dd'); -- ok
insert into test1 values(2, null, 'dd'); -- ok 
insert into test1 values(3, null, 'xx'); -- ok 
insert into test1 values(4, '', 'xx'); -- ok 
insert into test1 values(5, '', 'xx'); -- error: Duplicate entry

#2. outline 방식
create table test2 (
id int,
email varchar(10) unique,
name varchar(20),
primary key(id)); -- outline 방식

desc test2;

#3. 테이블 생성 후에 지정하기 : 미리 만든 테이블에 alter table
create table test3 (
id int,
email varchar(10) unique,
name varchar(20)
);
-- pk 조건 추가; add constraint 이름(여기서 제약 조건에 붙여주는 이름은 자유롭게 가능)
alter table test3 add constraint test3_pk primary key(id);
desc test3;
insert into test3 values(null, 'qqq', 'www'); -- error

-- sccottdb의 테이블을 복사해 와서 작업
-- 다른 db의 테이블을 create table로 복사해서 가져오는 경우는 제약 조건까지는 복사하지 못한다.
create table testdb.emp
as 
select *
from scottdb.emp;

select count(*) from emp;
create table dept as select * from scottdb.dept;
create table job as select * from scottdb.job;
create table loc as select * from scottdb.loc;
desc emp;

-- 각 테이블에 pk 지정하기
alter table emp add constraint emp_pk primary key(empid);
alter table dept add constraint dept_pk primary key(deptid);
alter table job add constraint job_pk primary key(jobid);
alter table loc add constraint loc_pk primary key(locid);
desc emp;
desc dept;
desc job;
desc loc;

-- fk 지정 : fk는 참조하는 쪽에서 지정
alter table emp add constraint emp_fk_deptid foreign key(deptid) references dept(deptid);
alter table emp add constraint emp_fk_jobid foreign key(jobid) references job(jobid);
alter table emp add constraint emp_fk_mgrid foreign key(mgrid) references emp(empid);
alter table dept add constraint dept_fk_locid foreign key(locid) references loc(locid);

create table members (
	mid varchar(10) primary key,
    name varchar(10) not null,
    tel varchar(10) not null,
    address varchar(2)
);

create table orders (
	oid int primary key,
    mid varchar(10),
    odate timestamp default current_timestamp,
    -- num int default 0,
    payment varchar(20) default 'money wire' not null,
    constraint pcheck check(payment in('credit card', 'money wire', 'point')));-- outline 형식, check 제약 조건, in: or와 같다고 생각
    
-- fk 지정
alter table orders
add constraint orders_fk foreign key (mid)
references members(mid) on delete cascade; -- on delete cascade: 부모 테이블 데이터 삭제 시 자동으로 자식 테이블 데이터까지 삭제

-- insert 시에는 부모테이블 먼저
insert into members values('1', 'tom', '1234', 'la');
insert into orders values(100, '1', null, 'point');
insert into orders(oid,mid) values(200, '1');

select * from members;
select * from orders;

delete from members where mid = '1';

-- index 확인 방법
-- show index from emp;

-- drop table Stu;

-- create table Stu (Roll_No int, 
-- Name varchar(50) unique,
-- email varchar(30) unique,
-- Gender varchar(30) not null, 
-- score int);

-- -- secondary index 생성
-- create index gindex on stu (gender);

-- -- index 삭제하는 2가지 방법
-- drop index gindex on stu;
-- alter table stu drop index gindex;

-- create index sindex on stu(score);

-- insert into Stu values (4, 'jankita', 'aa','female', 4876);
-- insert into Stu values (3, 'xanita', 'zz', 'male', 5675 );
-- insert into Stu values (5, 'ahima', 'mm', 'female', 3776 ); 

-- alter table Stu add constraint Stu_pk primary key(Roll_No);

-- select * from stu;

-- show index from stu;