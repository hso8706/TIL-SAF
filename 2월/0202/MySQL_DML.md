# **MySQL_DML**
## Index
1. 내장함수
2. Aggregation
3. Group By Clause
4. DML (Insert, Update, Delete)
5. Transaction

## 내장함수
### 종류
- 단일행 함수
  - 숫자 관련 함수
  - 문자 관련 함수
  - 날짜 관련 함수
  - 변환형 함수
  - NULL 관련 함수
- 다중행 함수
  - 집계 함수
  - 윈도우 함수
### 숫자 관련 함수
- 절대값, 올림, 내림, 반올림, 버림, x의 y승, 나머지, max, min
### 문자 관련 함수
- 아스키코드, concat, insert, replace, instr,substring, ltrim, rtrim, trim, lower, upper, left, right, mid, reverse, length
### 날짜 관련 함수
- 날짜, 시간, 연도, 월 리턴(영어로도 리턴)
- 날짜를 연산 후 반환
- 특정 주, 주별 일자 등 
- 날짜 형식 표현 가능
### 논리 관련 함수
- IF(논리식, 값1, 값2): 논리식이 참이면 값1이 리턴, 거짓이면 값2 리턴
- IFNULL(값1, 값2): 값1이 NULL이면 값2로 대치, NULL이 아니면 값1리턴
- NULLIF: 값1=값2가 TRUE이면 NULL, 그렇지 않으면 값1리턴