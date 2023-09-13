-- 기존 "industry" 테이블 삭제
DROP TABLE IF EXISTS industry;

-- "industry" 테이블 다시 생성
CREATE TABLE industry (
    industry_id INT(11) AUTO_INCREMENT PRIMARY KEY,
    type TEXT
);

/*
-- Query: SELECT * FROM junear.industry
LIMIT 0, 1000

-- Date: 2023-09-13 16:50
*/
INSERT INTO industry (`industry_id`,`type`) VALUES (1,'전기,전자');
INSERT INTO industry (`industry_id`,`type`) VALUES (2,'건설업');
INSERT INTO industry (`industry_id`,`type`) VALUES (3,'운수장비');
INSERT INTO industry (`industry_id`,`type`) VALUES (4,'의료정밀');
INSERT INTO industry (`industry_id`,`type`) VALUES (5,'섬유,의복');
INSERT INTO industry (`industry_id`,`type`) VALUES (6,'통신업');
INSERT INTO industry (`industry_id`,`type`) VALUES (7,'제조업');
INSERT INTO industry (`industry_id`,`type`) VALUES (8,'의약품');
INSERT INTO industry (`industry_id`,`type`) VALUES (9,'서비스업');
INSERT INTO industry (`industry_id`,`type`) VALUES (10,'화학');
INSERT INTO industry (`industry_id`,`type`) VALUES (11,'비금속광물');
INSERT INTO industry (`industry_id`,`type`) VALUES (12,'금융업');
INSERT INTO industry (`industry_id`,`type`) VALUES (13,'음식료품');
INSERT INTO industry (`industry_id`,`type`) VALUES (14,'종이,목재');
INSERT INTO industry (`industry_id`,`type`) VALUES (15,'기계');
INSERT INTO industry (`industry_id`,`type`) VALUES (16,'철강및금속');
INSERT INTO industry (`industry_id`,`type`) VALUES (17,'운수창고');
INSERT INTO industry (`industry_id`,`type`) VALUES (18,'유통업');
INSERT INTO industry (`industry_id`,`type`) VALUES (19,'전기가스업');
