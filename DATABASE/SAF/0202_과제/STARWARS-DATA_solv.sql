create database starwards;
use starwards;

-- 1
create table STARWARS(
	episodeid int,
    episodename varchar(50),
    openyear int
);

-- 2
create table CHARACTERS(
	characterid int,
    charactername varchar(30),
    masterid int,
    roleid int,
    email varchar(40)
);

-- 3
create table casting(
	episodeid int,
    characterid int,
    realname varchar(30)
);

-- 4
create table roles(
	roleid int primary key,
    rolename varchar(20)
);

insert into roles values(1001, '제다이');
insert into roles values(1002, '시스');
insert into roles values(1003, '반란군');

-- 5
alter table starwars
add constraint episode_pk primary key(episodeid);
alter table characters
add constraint characters_pk primary key(characterid);
-- alter table casting
-- add constraint casting_pk primary key(episodeid);

-- 6
alter table characters
add constraint characters_fk foreign key(roleid)
references roles(roleid);

-- 7
alter table casting
add constraint casting_pk primary key(episodeid, characterid);

alter table casting
add constraint casting_fk_epi foreign key(episodeid)
references starwars(episodeid);

alter table casting
add constraint casting_fk_cha foreign key(characterid)
references characters(characterid);