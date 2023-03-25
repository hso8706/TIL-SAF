DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id varchar(20) NOT NULL,
  pw varchar(20) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
LOCK TABLES user WRITE;
INSERT INTO user VALUES ('admin','admin'),('ssafy','ssafy');
UNLOCK TABLES;