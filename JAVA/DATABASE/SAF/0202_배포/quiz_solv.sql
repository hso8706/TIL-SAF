/*
*** 게시판 ***
- table 생성
	테이블명 : board
- column : 
	컬럼명		타입		제약조건		비고
    	no         		int       		pk            	자동증가
    	subject   		varchar(100)	NN
	register_time	timestamp	default now()

* data 입력 (insert)
1, 제목1, 현재시간기준 3일전입력
2, 제목2, 현재시간기준 2일전입력
3, 제목3, 현재시간기준 12시간전입력
4, 제목4, 현재시간기준 2시간전입력
5, 제목5, 현재시간입력

* data 출력 (select)
- 글작성 날짜가 오늘일 경우 10:25:32 (시:분:초) 
		  이 아닐 경우 23.02.02 (년.월.일)
- 최신글 순으로 정렬

* 출력 결과
5, 제목5, 10:25:32
4, 제목4, 08:25:32
3, 제목3, 23.02.01
2, 제목2, 23.01.31
1, 제목1, 23.01.30
*/
use ssafydb;
create table board(
no int primary key auto_increment,
subject varchar(100) not null,
register_time timestamp default now()
);

-- inset into {table_name} values();
-- 1
insert into board (subject, register_time) values('제목1', date_sub(now(), interval 3 day));
-- 2
insert into board (subject, register_time) values('제목2', date_sub(now(), interval 2 day));
-- 3
insert into board (subject, register_time) values('제목3', date_sub(now(), interval 12 hour));
-- 4
insert into board (subject, register_time) values('제목4', date_sub(now(), interval 2 hour));
-- 5
insert into board (subject) values('제목5');

-- 내 풀이
select no, subject,
case when date_format(register_time, '%y%m%d') = date_format(now(), '%y%m%d') then date_format(register_time, '%h:%i:%s')
	else date_format(register_time, '%y.%m.%e')
end '작성일' -- register_time으로 alias를 주게 되면 order by에서 alias로 정렬이 진행됨. 즉, 올바른 정렬이 진행되지 않음.
from board
order by register_time desc;
-- 교수님
select no, subject,
case date(register_time) when date(now()) then date_format(register_time, '%h:%i:%s')
	else date(register_time) -- date()를 쓰면 자동으로 연,월,일만 출력
end '작성일'
from board
order by register_time desc;
