create or replace view starwarsInfo
as
select episodeid, characterid, roleid, OPENYEAR, episodename, charactername, realname
from starwars s join casting caststarwarsinfo
using (episodeid)
join characters cha
using (characterid);

-- 전 스타워즈 시리즈의 상영년도, 영화제목, 배역, 출연배우 이름
select OPENYEAR, episodename, charactername, realname
from starwarsInfo
order by episodeid;

-- 에피소드 4에 출연한 배우는 모두 몇 명인지 구하는 쿼리
select count(distinct realname) `출연배우`
from starwarsinfo
where episodeid = 4;

-- 각 배우 별 출연횟수를 조회하는 쿼리
select realname, count(realname) `출연 횟수`
from starwarsinfo
group by realname;

-- 에피소드 별 이름과 출연자 수
select episodename, count(distinct realname) `출연자 수`
from starwarsinfo
group by episodename;

-- 제국의 역습에 등장하는 배우 이름
select realname `제국의 역습 출연 배우`
from starwarsinfo
where episodeid = 5;

-- 해리슨 포드가 등장했던 에피소드의 id와 에피소드 이름
select episodeid, episodename
from starwarsinfo
where realname = '해리슨 포드';

-- '아미달라 여왕'이 등장했던 에피소드 id와 배우명 
select episodeid, realname
from starwarsinfo
where charactername = '아미달라 여왕';

-- 8.가장 많은 인원이 출연한 에피소드 id와 인원수
-- 8-1.
select episodeid, count(*) `인원수`
from starwarsinfo
group by episodeid
having `인원수` = 
		(select count(*) cnt from starwarsinfo
        group by episodeid
        order by cnt desc
        limit 1);