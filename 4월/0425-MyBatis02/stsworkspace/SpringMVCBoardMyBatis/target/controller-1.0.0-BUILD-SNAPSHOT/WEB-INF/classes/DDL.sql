create table book (
	isbn int primary key auto_increment,
    authorid varchar(20) not null,
    genre varchar(20) not null,	
    title VARCHAR(40) not null,
	price int);
	
create table authors (
  authorid varchar(20) NOT NULL,
  pw varchar(20) NOT NULL,
  name varchar(20) NOT NULL,
  dormitory varchar(20) NOT NULL,
  PRIMARY KEY (authorid)
);	
alter table book add constraint book_fk foreign key (authorid) references authors(authorid);

insert into authors values('harry', '1234', 'Harry Porter', 'Gryffindor');
insert into authors values('malfoy', '1234', 'Draco Malfoy', 'Slytherin');
insert into authors values('hermione', '1234', 'Hermione Granger', 'Gryffindor');
insert into authors values('snape', '1234', 'Severus Snape', 'hogwart');
insert into authors values('admin', '1234', 'Kim Ssafy', 'samsung');


insert into book values(1, 'harry', 'history','long long my history', 18000);
insert into book values(2, 'hermione', 'thriller', 'who killed my tree?',23000);
insert into book values(3, 'malfoy', 'action', 'john wick4', 42000);


-- -------------------------------------------------------------------------






CREATE TABLE BOARD (
	NUM INT PRIMARY KEY auto_increment,
	PASS VARCHAR(20) NOT NULL,
	ID VARCHAR(20) NOT NULL,
	WDATE DATETIME NOT NULL,
	TITLE VARCHAR(40) NOT NULL,
	CONTENT VARCHAR(100) NOT NULL,
	COUNT INT DEFAULT 0 NOT NULL);
	
CREATE TABLE user (
  id varchar(20) NOT NULL,
  pw varchar(20) NOT NULL,
  name varchar(20) NOT NULL,
  dormitory varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
);	

 alter table board add constraint board_fk foreign key (id) references user(id);
INSERT INTO BOARD VALUES (1, 'guest', 'harry', sysdate(), '게시판 연습1', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (2, 'guest', 'harry', sysdate(), '게시판 연습2', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (3, 'guest', 'harry', sysdate(), '게시판 연습3', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (4, 'guest', 'harry', sysdate(), '게시판 연습4', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (5, 'guest', 'harry', sysdate(), '게시판 연습5', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (6, 'guest', 'snape', sysdate(), '게시판 연습6', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (7, 'guest', 'snape', sysdate(), '게시판 연습7', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (8, 'guest', 'snape', sysdate(), '게시판 연습8', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (9, 'guest', 'snape', sysdate(), '게시판 연습9', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (10, 'guest', 'snape', sysdate(), '게시판 연습10', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (11, 'guest', 'malfoy', sysdate(), '게시판 연습11', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (12, 'guest', 'malfoy', sysdate(), '게시판 연습12', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (13, 'guest', 'malfoy', sysdate(), '게시판 연습13', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (14, 'guest', 'malfoy', sysdate(), '게시판 연습14', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (15, 'guest', 'malfoy', sysdate(), '게시판 연습15', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (16, 'guest', 'hermione', sysdate(), '게시판 연습16', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (17, 'guest', 'hermione', sysdate(), '게시판 연습17', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (18, 'guest', 'hermione', sysdate(), '게시판 연습18', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (19, 'guest', 'hermione', sysdate(), '게시판 연습19', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (20, 'guest', 'hermione', sysdate(), '게시판 연습20', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (21, 'guest', 'hermione', sysdate(), '게시판 연습21', '게시판연습입니다.', 0);
INSERT INTO BOARD VALUES (22, 'guest', 'hermione', sysdate(), '게시판 연습22', '게시판연습입니다.', 0);


insert into user values('harry', '1234', 'Harry Porter', 'Gryffindor');
insert into user values('malfoy', '1234', 'Draco Malfoy', 'Slytherin');
insert into user values('hermione', '1234', 'Hermione Granger', 'Gryffindor');
insert into user values('snape', '1234', 'Severus Snape', 'hogwart');
insert into user values('admin', '1234', 'Kim Ssafy', 'samsung');

-- ---------------------------------------------------------
