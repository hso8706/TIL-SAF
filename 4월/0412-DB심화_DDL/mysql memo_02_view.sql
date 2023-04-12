-- view
/*
1) 물리적으로 존재하지 않는 가상의 테이블을 view라고 한다.(view를 만들 때 사용된 쿼리만 저장됨)
2) 보안성을 높이고 복잡한 쿼리를 재사용해서 사용할 수 있음.
3) view에 수정 작업(update, insert, delete)를 하면 원래 테이블에 반영이 된다.
4) view는 보통 조회의 용도로 사용한다.
*/

-- view 생성
-- create view emp4070로 대체 가능
-- as 키워드 사용(테이블 복사에도 as 키워드)
create or replace view emp4070
as 
select empid, fname, deptid, hdate
from emp
where deptid in (40,50,60,70);

select *
from emp4070; -- table을 조회하듯 볼 수 있다.

desc emp;
-- view 삭제
drop view emp4070;

-- join 예습
-- join을 사용하기 위해서는 공통된 column이 있어야 한다.
-- empid, fname, jobid, deptid, deptname(dept) -join
select empid, fname, jobid, d.deptid, deptname
from emp e, dept d -- e, d는 별칭 개념, e와 d로 호출 가능
where e.DEPTID = d.DEPTID;

create view emp2
as
select empid, fname, jobid, d.deptid, deptname
from emp e, dept d -- e, d는 별칭 개념, e와 d로 호출 가능
where e.DEPTID = d.DEPTID;

-- empid, fname, jobid, jobtitle
-- view emp3
create view emp3
as
select empid, fname, j.jobid, jobtitle
from emp e, job j
where e.jobid = j.jobid;

-- empid, fname, deptname, jobtitle
-- emp4
create view emp4
as
select empid, fname, deptname, jobtitle
from emp e, dept d, job j
where e.deptid = d.deptid
and e.JOBID = j.JOBID;

select * from emp4;

-- inline view
select empid, fname, e.deptid, deptname
from emp e, dept d
where e.deptid = d.deptid
order by salary;

select empid, fname, deptname
from( -- from 절 내부에서 사용된 view(select 문) ==> 인라인 view
select empid, fname, e.deptid, deptname
from emp e, dept d
where e.deptid = d.deptid
order by salary
) tmp -- tmp : 인라인 뷰의 별칭, 인라인 뷰를 만들때에는 인라인 뷰의 별칭을 다는 것이 필수이다.
where tmp.deptid >30
limit 5;