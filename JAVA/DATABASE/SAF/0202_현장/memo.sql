use scottdb;

# 함수
# 1) 집계함수: count(), max(), min(), avg(), sum()
select count(empid) 사원수, count(deptid) 부서수
from emp;

select count(*) from emp; # 특정 컬럼을 지정하지 않고, emp의 records를 모두 카운트

# emp -> 최고 연봉, 최저 연봉, 평균 연봉, 연봉 합계
select max(salary), min(salary), round(avg(salary)), sum(salary)
from emp;

# 2) 숫자관련 함수
select ceil(3.1); -- 올림
select floor(2.9); -- 내림
select round(3.4567, 2); -- 반올림: 소수점 둘째자리까지, 소수점 둘째자리까지 보이게
select greatest(2,4,1); -- 최대값 찾기, max랑 다른가?
select least(2,4,1); -- 최소값 찾기

# 3) 문자열 관련 함수
select empid 사번, concat(fname, ' ', lname) 이름 from emp; -- 문자열 합치기
select fname, replace(fname, 'e', 'x') from emp; -- 문자열 교체
select fname, right(fname, 2) from emp; -- 특정 부분 추출(우측)
select fname, substr(fname, 1, 2) from emp; -- 특정 부분 추출(idx); DB idx는 1부터 시작!
select fname, reverse(fname), ucase(fname), lcase(fname) from emp; -- 거꾸로 출력 -- 대문자 변경 -- 소문자 변경
select fname, rpad(fname, 10, '#') from emp; -- pad: 빈 문자열을 채우는 함수, rapd: 우측의 빈 공간을 채우는 함수
select fname, lpad(fname, 10, '*') from emp;

# 4) 날짜 관련 함수
select now(), sysdate(), curdate(), curtime();
select now(), date_add(now(), interval 1 hour); -- 대여관련된 데이터에 사용하기 좋음
select year(now()), month(now()), monthname(now()), dayofweek(now()); -- day는 일요일(1)부터 시작
select fname, hdate, dayofmonth(hdate) from emp;
select fname, hdate, date_format(hdate, '%Y'), hdate, date_format(hdate, '%y'),
date_format(hdate, '%M'), date_format(hdate, '%m'),
date_format(hdate, '%D'), date_format(hdate, '%d')
from emp; -- 출력 포맷 지정(날짜); 대문자 소문자 구분됨.

# 5) JSON 형식으로 표현
select json_object('empid', empid, 'fname', fname) from emp; -- {"empid": empid_values, "fname": fname_values}

# 6) null check ###중요### 시험에서 나올듯; null 체크하고 다른 값을 요청하거나 함
select comm, jobid, if(comm, 1, 0), -- null이 아니면 1, null이면 0 (영업직`SA_`만 확인)
			 ifnull(comm, 'none'), -- null이 아니면 값, null이면 'none'(대체값)
			 coalesce(comm, 'nope') -- null이 아니면 값, null이면 'nope'(대체값); coalesce(a, b, c, ...) : 여러개의 인자 값 중 최초로 null이 아닌 값을 반환, null에 대해서는 default(문자열)값을 데체 반환하는 듯
from emp;

# 7) case ~ when: 조건을 둬서 경우에 맞게 작동하도록
select empid, fname, salary,
	case when salary > 15000 then 'high' -- select에 들어가는 값
		 when salary > 8000 then 'mid'
		 else 'low'
	end grade -- grade는 alias
from emp;