-- use 키워드 : 사용하려는 DB 지정
use scottdb;

-- describe
desc emp;

-- select all(*) : *보다는 모든 컬럼명을 입력하는게 속도가 빠르다네
select * 
from emp;

-- distinct, all : 중복 제거
select deptid
from emp; -- 107 rows
select distinct deptid
from emp; -- 12 rows
select distinct deptid, jobid -- deptid와 jobid가 동시에 중복되는 경우 제거
from emp; -- 20 rows

-- order by : 오름차순(asc)을 기본값으로 하여 정렬하는 쿼리문
select empid, fname, jobid, hdate
from emp
order by hdate;
select empid, fname, jobid, hdate
from emp
order by hdate desc; -- 내림차순 옵션
select empid, fname, jobid, hdate
from emp
order by hdate desc, fname desc; -- hdate 기준으로 내림차순 후, 입사 날짜가 같다면 fname 기준으로 내림차순
select empid, fname, jobid, hdate
from emp
order by 2 desc; -- index로 정렬하는 방법, select에 제공한 인자의 index( 2 == fname)

-- 입사일 빠른 순, 연봉 높은 순 (입사일 먼저, 입사일이 같다면 연봉 기준)
select empid, fname, hdate, salary
from emp
order by hdate, salary desc;

-- alias(별칭; 컬럼 헤더의 별칭)
select empid as 사번, fname 이름, email "이메일" -- 1. as: 생략 가능/ 2. as를 생략한 결과/ 3. 쌍따옴표 사용(공백을 표기하기 위함. 나머지는 공백 표현 불가)
from emp;

-- 연산자 (산술 연산자, 비교 연산자, 논리 연산자 ...)
select empid 사번, fname 이름, salary "현재 연봉", salary * 1.1 "새 연봉" -- 현재 연봉의 10%가 증가된 금액이 새연봉 
from emp
order by "새 연봉" desc; -- 새로운 alias로 정렬 가능

-- where(조건) : 코드 순서 (1) from, (2) where, (3) select
select empid, fname, deptid
from emp	
where deptid >= 50;
select empid, fname, deptid -- where and 사용
from emp	
where deptid >= 50
and salary > 10500;
select empid, fname, deptid -- where or 사용
from emp	
where deptid >= 50
or deptid <= 20;

-- jobid가 'IT_PROG'인 사원의 정보
select empid, fname, deptid, jobid
from emp
where jobid = 'IT_PROG'; -- 문자열은 작은 따옴표로 묶음('')

-- null 값 비교(is null, is not null)
select empid, fname, deptid
from emp; -- 107 rows, 178, Kiemerely, null
select empid, fname, deptid
from emp
where deptid is not null; -- 106 rows

-- 커미션을 받지 않는 직원 정보
select empid, fname, jobid
from emp
where comm is null; -- 72 rows

-- in : or의 의미
select empid, lname, deptid
from emp
where deptid in(10, 50); -- 10이거나 50

-- between : 작성 범위 포함
select empid, fname, salary
from emp
where salary between 9000 and 12000; -- 9000 <= salary <= 12000

select empid, fname, salary
from emp
where salary between 9000 and 12000
order by salary desc, hdate;

-- 입사일이 2005/03/01 ~ 2005/05/31일 사이 직원 정보. 오름차순 정렬
select empid, fname, salary
from emp
where hdate between '2005/03/01' and '2005/05/31' -- 빠른 날짜가 더 작은 값, date는 문자열
order by 3;

-- 중요 단골 메뉴
-- like(유사 검색) : `=`은 완벽 일치, like는 와일드카드를 사용함
-- % 와일드카드 사용
select empid, lname
from emp
where lname like '%e%'; -- % 아무 길이의 값이 올 수 있음. e만 포함되면 호출 => 검색 기능에 사용할 수 있을 듯 함
-- _ 와일크카드 사용 : 글자수 확인
select empid, fname
from emp
where fname like 'A___';

-- 다른 테이블 확인
desc dept;

select *
from dept;

select * 
from job;

select * 
from job
where jobid = 'PU_MAN';

select * 
from loc
where locid = 1300;

--
