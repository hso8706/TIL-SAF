-- 그룹함수
-- 급여의 총합, 커미션의 총합


-- 평균급여 (소수 2자리까지 표현)


-- 사원수


-- 사원이 근무하는 부서의 개수, 커미션을 받는 사원수


-- 80번 부서에서 근무하는 사원중 최고급여, 최저급여


-- 부서 번호, 부서별 급여의 총합, 평균급여



-- 각 부서별 최고 급여와 최저 급여


-- 각 부서별 최고 급여를 받는 사원의 부서번호, 사번, 이름, 급여. 
-- join 이용
select a.department_id, e.employee_id, e.first_name, a.smax
from employees e join (
					   select department_id, max(salary) as smax
					   from employees
					   group by department_id
                       ) a
on e.department_id = a.department_id
and e.salary = a.smax;

-- 다중열 subquery 이용
select department_id, employee_id, first_name, salary
from employees
where (department_id, salary) in ( select department_id, max(salary)
								   								 from employees
                                   group by department_id)
order by department_id;


-- having
-- 부서별 평균 급여가 7000이상인 부서 번호, 평균 급여


-- 40, 50, 60번 부서에서 근무하는 사원들중 job_id별 급여 합이 50000보다 큰 job_id와 평균 급여
-- 평균급여를 내림차순으로 정렬


-- 부서별 평균 급여가 20번 부서의 평균 급여보다 큰 부서의 부서번호, 평균 급여


