## inner join - where 절에서 테이블을 연결할 수 있는 공통의 컬럼을 명시
-- 1. empid, fname, deptid, deptname
select empid, fname, d.deptid, deptname
from emp e, dept d
where e.deptid = d.deptid;

-- 2. empid, fname, jobid, jobtitle
select empid, fname, e.jobid, jobtitle
from emp e, job j
where e.jobid = j.jobid;

-- 3. deptid, deptname, city
select deptid, deptname, city
from dept d, loc l
where d.locid = l.locid;

-- 4. empid, fname, deptname, jobtitle
select empid, fname, d.deptname, j.jobtitle
from job j, emp e, dept d
where j.jobid = e.jobid
and d.deptid = e.deptid
and e.deptid is not null;

-- 5. join~on
select empid, fname, d.deptid, deptname
from emp e inner join dept d -- inner 키워드는 생략해도 디폴트 값으로 사용됨
where e.deptid = d.deptid;

-- 6. join~on
select empid, fname, d.deptname, j.jobtitle
from emp e join dept d -- emp, dept join
on e.deptid = d.deptid
join job j -- 추가로 job 을 join
on e.jobid = j.jobid
and e.deptid is not null; -- where이 없음에도 and 키워드가 먹힘alter

-- 7. join~using
select empid, fname, e.deptid, deptname
from emp e join dept d
using (deptid); -- 조인하는 테이블에 있는 공통 컬럼명

-- 8. 자신의 직급에 따른 minsal, maxsal
select empid, fname, salary, minsal, maxsal
from emp e join job j
using (jobid);

-- 9. 부서별 deptid, deptname, 인원수(인원수가 5명 이상인), (인원수 많은 순서대로 정렬)
select d.deptid, deptname, count(*) cnt
from emp e, dept d
where e.deptid = d.deptid
group by deptid, DEPTNAME -- group 나눌 때 주의사항: 집계함수말고는 select에 넣을 항목을 모두 넣어줘야한다.
having cnt >= 5 -- having절: group에 거는 조건
order by cnt desc;

## outer join : 조인 조건에 사용되는 공통 컬럼의 값이 null인 경우를 위해 가상의 레코드를 추가해 주는 조인 방식
-- outer join은 on을 사용해야한다. left, right를 사용할 땐 outer 생략 가능하다.
-- 10.
select count(*) from emp; -- 107개
select empid, fname, e.deptid, deptname
from emp e left outer join dept d -- left, right: 기준이 되는 테이블을 지정하는 방법, 기준이 아닌 테이블에는 자동으로 필요한 가상의 레코드를 만들어줌
on e.deptid = d.deptid; -- 106개: deptid가 null인 레코드가 있기 때문

-- 11. deptid, deptname, manager_name
select d.deptid, deptname, fname manager_name
from emp e join dept d -- dept table엔 manager id가 없는 부서가 존재
on d.mrgid = ecmpid; 	
-- on e.deptid = d.deptid

-- 12. empid, fname, deptame, city
select empid, fname, deptname, city
from emp e left join dept d
on e.deptid = d.DEPTID
join loc l
on d.locid = l.locid;

## self join - 하나의 테이블을 서로 다른 테이블처럼 사용해 조인하는 방식
-- 13. 직원 별 매니저 이름
-- select empid, fname, mgr_name 
select e1.empid, e1.fname, e2.fname 
-- from emp e1, emp e2
-- where e1.MGRID = e2.EMPID;
from emp e1 left join emp e2 -- Steven 처리를 위해서 outer self join 사용
on e1.MGRID = e2.EMPID; -- 같은 테이블의 다른 컬럼을 연결해서 마치 두 개의 테이블이 엮인 것처럼 사용

## Sub Query
-- 1. 최저 연봉을 받는 직원 이름(empid, fname, salary)
select empid, fname, salary
from emp e
where salary = (select min(salary) from emp);

-- 2. 전체 연봉 평균보다 많이 받는 직원 정보
select empid, fname, salary
from emp
where salary >= (select avg(salary) from emp)
order by 3 desc;

-- 3. 미국에 있는 부서id, 부서명 (서브쿼리)
select deptid, deptname
from dept
where locid in (select locid
				from loc
                where countryid = "US");
-- 3-1. join
select deptid, deptname
from dept d join loc l
on d.locid = l.locid
where l.countryid = "US";

                
-- 4. 미국에서 근무하는 직원들의 평균 연봉
select avg(salary)
from emp
where deptid in (select deptid
				from dept
				where locid in (select distinct(locid)
								from loc
								where countryid = "US"));

-- 5. 60번 부서 직원들과 동일한 연봉을 받는 직원 정보(60번 직원 포함)
select *
from emp
where salary in (select salary
				from emp
				where deptid = 60);
                
-- 6. 60번 부서 직원이 받는 연봉 중 아무거나 비교해서 더 높은 연봉을 받는 직원 정보 - 61건
-- 아무거나 비교 == 누구와도 상관없으니 비교해서 내가 더 높으면 된다 == 최소인 사람과 비교하는것이 가장 유리하다.
select *
from emp
where salary > any (select salary -- any 대신 min(salary)도 가능
				from emp
				where deptid = 60);

-- 7. 60번 부서 직원이 받는 연봉 어떤 것과 비교해도 더 높은 연봉을 받는 직원 정보 - 23건
select *
from emp
where salary > (select max(salary) -- max 대신 all select도 가능
				from emp
				where deptid = 60);

## 다중 컬럼 리턴
select empid, fname, mgrid
from emp
where (salary, deptid) in ( -- 동시에 같아야함.
			select salary, deptid
            from emp
            where comm is not null	
            and mgrid = 148);
            
## 인라인 뷰
-- 1. 
select e.empid, e.fname, e.salary, e.deptid
from (
	select distinct deptid
    from emp
    where salary < (select avg(salary) from emp)
    ) d join emp e
on d.deptid = e.deptid;

-- 1-1. subq
select empid, fname, salary, deptid
from emp
where deptid in (select deptid from emp where salary < (select avg(salary) from emp))
order by empid;