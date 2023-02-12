use ssafydb;

-- 모든 사원의 모든 정보 검색.
select *
from employees;


-- 사원이 근무하는 부서의 부서번호 검색.
select department_id
from employees;


-- 사원이 근무하는 부서의 부서번호 검색.(중복제거)
select distinct department_id
from employees;


-- 회사에 존재하는 모든 부서.
select *
from departments;


-- 모든 사원의 사번, 이름, 급여 검색. (: 컬럼 나열 가능)
select employee_id, first_name, salary
from employees;


-- 모든 사원의 사번, 이름, 급여, 급여 * 12 (연봉) 검색. (: 데이터 사칙 연산 가능)
select employee_id, first_name, salary, salary * 12
from employees;
-- 추가 알리아스(?) 표현 방법, 별칭인듯, 3가지 방법, 쌍따옴표를 쓰지 않으면 공백은 불가능함.
select employee_id as 사번, first_name 이름, salary "급여", salary * 12
from employees;

-- 모든 사원의 사번, 이름, 급여, 급여 * 12 (연봉), 커미션, 커미션포함 연봉 검색. (: 커미션이 있을 경우, 없을 경우를 구분할 필요 있음)
select employee_id as 사번, first_name 이름, salary "급여", salary * 12 "연  봉",
commission_pct, salary * (1 + ifnull(commission_pct, 0)) * 12 "커미션포함 연봉" -- ifnull(a, b); a: 해당 값인이 null인지 아닌지 파악, b: a가 null이면 넣어줄 값

from employees;


-- 모든 사원의 사번, 이름, 급여, 급여에 따른 등급표시 검색.
-- 급여에 따른 등급
--   15000 이상 “고액연봉“      
--   8000 이상 “평균연봉”      
--   8000 미만 “저액연봉＂
select employee_id, first_name, salary,
		case 
			when salary >= 15000 then "고액연봉"
			when salary >= 8000 then "평균연봉"
            else "저액연봉"
		end "등급",
        case employee_id when 100 then "스티븐이군요"
			else "스티	븐이아니네요"
		end "스티븐이니?"
from employees;

-- 부서번호가 50인 사원중 급여가 7000이상인 사원의
-- 사번, 이름, 급여, 부서번호
select employee_id, first_name, salary, department_id
from employees
where department_id = 50 -- db에서는 `=`가 비교 연산자
and salary >= 7000;  -- `&&`도 되지만 쿼리문에서는 and로 쓰는 것이 좋음


-- 근무 부서번호가 50, 60, 70에 근무하는 사원의 사번, 이름, 부서번호

select employee_id, first_name, department_id
from employees
where department_id = 50
or department_id = 60
or department_id = 70;



-- 근무 부서번호가 50, 60, 70이 아닌 사원의 사번, 이름, 부서번호
	-- 두 방법 다 옳음, 하지만 전자가 조금 더 일반적임
select employee_id, first_name, department_id
from employees
where department_id != 50
and department_id != 60
and department_id != 70;

select employee_id, first_name, department_id
from employees
where not (department_id = 50
or department_id = 60
or department_id = 70);

-- 근무 부서번호가 50, 60, 70에 근무하는 사원의 사번, 이름, 부서번호
-- 이쪽 설명 다시


-- 근무 부서번호가 50, 60, 70이 아닌 사원의 사번, 이름, 부서번호 



-- 급여가 6000이상 10000이하인 사원의 사번, 이름, 급여
select employee_id, first_name, department_id
from employees
where salary >= 6000
and salary <= 10000;

select employee_id, first_name, department_id
from employees
where salary between 6000 and 10000; -- 이상 ~ 이하 (해당 값 포함)


-- 근무 부서가 지정되지 않은(알 수 없는) 사원의 사번, 이름, 부서번호 검색.
select employee_id, first_name, department_id
from employees
where department_id = null; -- null은 알 수 없다이기 때문에 `=` 비교 연산자로는 불가능하다

select employee_id, first_name, department_id
from employees
where department_id is null; -- `is` 키워드 사용

select employee_id, first_name, department_id
from employees
where department_id is not null; -- is 활용 (부정)

-- 커미션을 받는 사원의 사번, 이름, 급여, 커미션
-- select employee_id, first_name, salary, commission_pct
-- from employees



-- 이름에 'x'가 들어간 사원의 사번, 이름
select employee_id, first_name
from employees
where first_name like '%x%'; -- like 키워드와 와일드카드(`%` 혹은 `_`)


-- 이름의 끝에서 3번째 자리에 'x'가 들어간 사원의 사번, 이름
select employee_id, first_name
from employees
where first_name like '%x__'; -- 와일드카드(`_`) : 자릿수까지 고려


-- 모든 사원의 사번, 이름, 급여
-- 단 급여순 정렬(내림차순)
select employee_id, first_name, salary
from employees
order by salary; -- 기본값 오름차순

select employee_id, first_name, salary
from employees
order by salary desc; -- 내림차순

-- 50, 60, 70에 근무하는 사원의 사번, 이름, 부서번호, 급여
-- 단, 부서별 정렬(오름차순) 후 급여순(내림차순) 검색

-- select employee_id, first_name, department_id,salary
-- from employees
-- whehe department_id (50, 60, 70)
-- oreder--  bt
