-- 1
use world ;
-- 2 
desc city;
desc country;
desc countrylanguage;
-- 3 
select *
from country
where code = 'KOR';
-- 4 
select code, name, gnp, GNPOld, (gnp-gnpold) "gnp변동량"
from country
where (gnp-gnpold) > 0
order by gnp변동량;
-- 5
select distinct Continent
from country;
-- 6
select concat(name, "은 ", region, "에 속하며 인구는 ", population, "명이다.") 정보
from country
where continent = 'asia';
-- 7
select name, continent, gnp, Population
from country
where IndepYear is null
and Population >= 10000
order by Population;
-- 8
select code, name, Population
from country
where Population between 100000000 and 200000000
order by Population desc
limit 3;
-- 9 
select code, name, IndepYear
from country
where IndepYear = 800
or IndepYear = 1810
or IndepYear = 1811
or IndepYear = 1901
order by IndepYear, code desc;
-- 10
select code, name, Region
from country
where Region like '%Asia%'
and name like '_o%';
-- 11 (utf-8 설정)
select round(length('홍길동')/3) 한글, length('hong') 영문;
-- 12
select code, name, GovernmentForm
from country
where GovernmentForm like '%Republic%'
and length(name) >= 10
order by length(name) desc
limit 10;
-- 13 (다른 방법?)
select code, name
from country
where code like 'A%'
or code like 'E%'
or code like 'I%'
or code like 'O%'
or code like 'U%'
order by name
limit 2, 3;
-- 14 (쪼갠 만큼 별로 바꿔야함)
select name, concat(left(name, 2), mid(regexp_replace(name, '[a-z]', '*'), 2, length(name)-4), right(name, 2)) as guess --  mid(regexp_replace(name, '[a-z]', '*'), 2, length(name)-4), 쪼갠 가운데 regexp_replace(name, '[a-z]', '*')
from country;
-- 15
select distinct replace(region, ' ', '_') 지역들
from country
order by length(지역들) desc;
-- 16
select name, SurfaceArea, Population, round(SurfaceArea / Population, 3) '1인당 점유면적'
from country
where Population >= 100000000
order by round(SurfaceArea / Population, 3); -- alias로 왜 정렬이 안되지?