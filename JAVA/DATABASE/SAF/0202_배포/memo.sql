# 숫자 관련 함수

select @@version;# MYSQL은 FROM절이 없어도 에러가 안뜸. 다른건 뜸

select *
from dual; # 가변적인 컬럼을 갖는 테이블, 이렇게만 쓰는건 에러

-- 절대값
select abs(-5), abs(5), abs(+5)
from dual;

-- 올림, 내림
select ceil(12.912), ceiling(12.912), ceil(-12.912), ceiling(-12.912)
from dual; 

select floor(12.912), floor(-12.912)
from dual;

-- 반올림, 버림
-- 기본 자릿수 = 0: 0번째까지 반올림
select round(1823.9123), round(1823.9123, 0), round(1823.9123, 1), round(1823.9123, -2)
from dual;

-- 기본 자릿수가 없음, 반드시 자릿수 지정
select truncate(1823.9123, 0), truncate(1823.9123, 1), truncate(1823.9123, -2)
from dual;

-- 제곱승, 나머지, 최대, 최소
select pow(2, 3), power(2, 3)
from dual;

select mod(10, 4) -- 출력 : 2
from dual;

select greatest(1, 4, 8, 2, 6), least(1, 4, 8, 2, 6) -- 출력 : 8, 1
from dual;

-- 날짜 관련
select now(), sleep(5), now() -- current_timestamp()랑 똑같음. select가 되는 시점
from dual;

select sysdate(), sleep(5), sysdate() -- select가 실행되는 시점
from dual;

-- 집계
select *
from employees; -- 놓침

-- group by
select @@sql_mode;
-- SET SESSION sql_mode = 'NO_ENGINE_SUBSTITUTION,STRICT_TRANS_TABLES'; -- 에러안나게 세팅하는 방법