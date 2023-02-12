# group~by, 시험에 나올 확률 높음
# : `~~별 데이터를 구하여라`라는 식으로 `~별`같은 키워드를 쓰면 그룹핑하는 것을 염두할 것.
# 1) 부서별 인원 수
select empid, fname -- 행의 갯수(데이터, records)가 맞아야 출력됨
from emp;
 -- error 발생: count(*)의 값은 1개임. 모든 데이터를 센 총합을 냄
select deptid, count(*)
from emp;
 -- error 해결
 -- 실행 순서: 1)from - 2)group by - 3)select
select deptid, count(*)
from emp
group by deptid;
--
select deptid, count(*)
from emp
where deptid is not null -- null 값 제외
group by deptid
order by deptid; -- 정렬

-- jobid 별 인원수, 연봉평균(소수 1자리), 연봉 기준 내림차순
select jobid, count(*) 'job별 인원수', round(avg(SALARY), 1) 연봉평균
from emp
group by jobid
order by 연봉평균 desc; -- alias로 가능

-- select 절에 나오는 컬럼명은 집계함수를 제외하고 모두 group by 절에 나와야 함.
select deptid, jobid, count(*) -- jobid는 그룹핑이 되지 않았기 때문에 모든 레코드가 호출됨, 하나의 부서에 업무가 다를 수도 있기때문
from emp
group by deptid; -- 에러를 해결하기 위해서는 jobid도 그룹핑하면 된다.

-- 20, 30, 50번 부서의 jobid별 평균 임금
select deptid, jobid, avg(salary)
from emp
where deptid in (20, 30, 50)
group by deptid, jobid
order by deptid;

-- 부서 별 인원수 구하기 + 인원수가 5명 이상인 경우만(그룹에 조건)
select deptid, count(*) cnt
from emp
where deptid is not null
group by deptid
having cnt >= 5
order by deptid;

-- deptid가 50 이상인 부서 중 jobid별로 평균 임금이 8000 이상인 레코드의 jobid, 평균임금(소수점 안나오게)
select deptid, jobid, round(avg(salary)) average
from emp
where deptid >= 50
group by deptid, jobid
having average > 8000
order by average desc;