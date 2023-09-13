-- 'company' 테이블이 이미 존재하는 경우 삭제
DROP TABLE IF EXISTS company;

-- 'company' 테이블 생성
CREATE TABLE company (
    cor_code VARCHAR(255), -- 기업 코드
    cor_name VARCHAR(255), -- 기업명
    activity_rank VARCHAR(255),     -- 안정성 등급
    growth_rank VARCHAR(255),       -- 수익성 등급
    profitability_rank VARCHAR(255),-- 활동성 등급
    stability_rank VARCHAR(255)     -- 성장성 등급
);


-- 'activity_rank' 테이블에서 데이터 가져와서 'company' 테이블과 조인
INSERT INTO company (cor_code, cor_name, activity_rank)
SELECT ar.cor_code, ar.cor_name, ar.rank
FROM activity_rank ar;

-- 'growth_rank' 테이블에서 데이터 가져와서 'company' 테이블과 조인
UPDATE company c
JOIN growth_rank gr ON c.cor_code = gr.cor_code
SET c.growth_rank = gr.rank;

-- 'profitability_rank' 테이블에서 데이터 가져와서 'company' 테이블과 조인
UPDATE company c
JOIN profitability_rank pr ON c.cor_code = pr.cor_code
SET c.profitability_rank = pr.rank;

-- 'stability_rank' 테이블에서 데이터 가져와서 'company' 테이블과 조인
UPDATE company c
JOIN stability_rank sr ON c.cor_code = sr.cor_code
SET c.stability_rank = sr.rank;

-- activity_rank 컬럼의 타입을 INT로 변경하고 등급 매핑 (NULL 값은 그대로 유지)
UPDATE company
SET activity_rank = CASE
    WHEN activity_rank IS NULL THEN NULL
    WHEN activity_rank = 'Unranked' THEN 0
    WHEN activity_rank = 'Bronze' THEN 1
    WHEN activity_rank = 'Silver' THEN 2
    WHEN activity_rank = 'Gold' THEN 3
    WHEN activity_rank = 'Platinum' THEN 4
    WHEN activity_rank = 'Diamond' THEN 5
    WHEN activity_rank = 'Master' THEN 6
    WHEN activity_rank = 'Challenger' THEN 7
    ELSE activity_rank
END;
ALTER TABLE company
MODIFY COLUMN activity_rank INT;

-- growth_rank 컬럼의 타입을 INT로 변경하고 등급 매핑 (NULL 값은 그대로 유지)
UPDATE company
SET growth_rank = CASE
    WHEN growth_rank IS NULL THEN NULL
    WHEN growth_rank = 'Unranked' THEN 0
    WHEN growth_rank = 'Bronze' THEN 1
    WHEN growth_rank = 'Silver' THEN 2
    WHEN growth_rank = '                                                                                                                                                                                                                                                                                                                                                                                                       Gold' THEN 3
    WHEN growth_rank = 'Platinum' THEN 4
    WHEN growth_rank = 'Diamond' THEN 5
    WHEN growth_rank = 'Master' THEN 6
    WHEN growth_rank = 'Challenger' THEN 7
    ELSE growth_rank
END;
ALTER TABLE company
MODIFY COLUMN growth_rank INT;

-- profitability_rank 컬럼의 타입을 INT로 변경하고 등급 매핑 (NULL 값은 그대로 유지)
UPDATE company
SET profitability_rank = CASE
    WHEN profitability_rank IS NULL THEN NULL
    WHEN profitability_rank = 'Unranked' THEN 0
    WHEN profitability_rank = 'Bronze' THEN 1
    WHEN profitability_rank = 'Silver' THEN 2
    WHEN profitability_rank = 'Gold' THEN 3
    WHEN profitability_rank = 'Platinum' THEN 4
    WHEN profitability_rank = 'Diamond' THEN 5
    WHEN profitability_rank = 'Master' THEN 6
    WHEN profitability_rank = 'Challenger' THEN 7
    ELSE profitability_rank
END;
ALTER TABLE company
MODIFY COLUMN profitability_rank INT;

-- stability_rank 컬럼의 타입을 INT로 변경하고 등급 매핑 (NULL 값은 그대로 유지)
UPDATE company
SET stability_rank = CASE
    WHEN stability_rank IS NULL THEN NULL
    WHEN stability_rank = 'Unranked' THEN 0
    WHEN stability_rank = 'Bronze' THEN 1
    WHEN stability_rank = 'Silver' THEN 2
    WHEN stability_rank = 'Gold' THEN 3
    WHEN stability_rank = 'Platinum' THEN 4
    WHEN stability_rank = 'Diamond' THEN 5
    WHEN stability_rank = 'Master' THEN 6
    WHEN stability_rank = 'Challenger' THEN 7
    ELSE stability_rank
END;
ALTER TABLE company
MODIFY COLUMN stability_rank INT;

-- total_rank 컬럼 추가 및 각 행의 평균 값 계산하여 업데이트
ALTER TABLE company
ADD COLUMN total_rank DECIMAL(5, 2); -- DECIMAL 타입을 사용하여 소수점 두 자리까지 저장

UPDATE company
SET total_rank = (
    COALESCE(activity_rank, 0) + COALESCE(growth_rank, 0) + COALESCE(profitability_rank, 0) + COALESCE(stability_rank, 0)
) / (
    CASE WHEN activity_rank IS NOT NULL THEN 1 ELSE 0 END +
    CASE WHEN growth_rank IS NOT NULL THEN 1 ELSE 0 END +
    CASE WHEN profitability_rank IS NOT NULL THEN 1 ELSE 0 END +
    CASE WHEN stability_rank IS NOT NULL THEN 1 ELSE 0 END
);

-- 결과 확인
SELECT * FROM company;

-- industry 테이블 생성
CREATE TABLE industry (
    industry_id INT AUTO_INCREMENT PRIMARY KEY,
    type TEXT
);

-- news 테이블의 type 값을 industry 테이블로 복사
INSERT INTO industry (type)
SELECT DISTINCT type FROM news;

-- industry 테이블 확인
SELECT * FROM industry;

ALTER TABLE news
ADD COLUMN industry_id INT,
ADD CONSTRAINT fk_industry_id
FOREIGN KEY (industry_id) REFERENCES industry (industry_id);

UPDATE news n
JOIN industry i ON n.type = i.type
SET n.industry_id = i.industry_id;

SELECT 
    SUBSTRING(
        REPLACE(cor_type, 'KSE 코스피', ''),
        2
    ) AS modified_cor_type
FROM
    activity_rank;