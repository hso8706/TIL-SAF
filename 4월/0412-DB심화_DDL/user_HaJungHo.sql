-- 1.
CREATE SCHEMA test_user DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;
-- 2.
DROP TABLE IF EXISTS user;
-- 3.
create table user (
age int not null,
email varchar(40) not null,
id varchar(40) not null,
name varchar(40) not null,
password varchar(40) not null
);
-- 4.
alter table user add phone_number int;
-- 5
alter table user modify column phone_number varchar(40) NOT NULL;
-- 6
alter table user drop phone_number;
-- 7
insert into user (id,password,name,email,age) values 
('BlackWidow','1278','나타샤 로마노프','blackwidow@ssafy.com',38),
('CaptainAmerica','5678','스티브 로저스','Captain@ssafy.com',30),
('Hulk','2486','브루스 배너','hulk@ssafy.com',54),
('IronMan','1234','토니 스타크','ironman@ssafy.com',53),
('Thor','1111','토르','GodOfThunder@ssafy.com',1500),
('Ultron','2355','울트론','ultron@ssafy.com',0);
-- 8
update user
set email = 'Thor@ssafy.com'
where name = '토르'; 
-- 9
delete from user where age >= 1000;
-- 10
delete from user;