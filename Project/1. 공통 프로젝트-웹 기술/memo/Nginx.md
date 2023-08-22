### 역할
- 리버스 프록시
  - 보안: 내부 코드에 직접적인 접근을 할 수 없게 만듬
  - SSL을 적용하기 위해서는 무조건 있어야하는 부분
- 로드 밸런스
  - 동시 접속으로인한 문제 발생을 줄여줌
- API gateway
- 보안 차원(ddos 공격 방어 가능)

### 특징
- 비동기 방식
- 정적 파일 서비스에 뛰어난 성능(톰캣에 대비)

### 추가 스터디 필요

### 참고 링크
- https://whatisthenext.tistory.com/123


# 사용

## 1. Nginx 설치 및 Nginx 기본 화면 확인
### 설치
  ```
  sudo apt update
  sudo apt install nginx
  ```
### 실행, 종료, 확인
  ```
  실행: sudo systemctl start nginx
  확인: sudo systemctl status nginx
  종료: sudo systemctl stop nginx
  ```
  - 실행 중 확인 : `Active: active (running)`
  - 종료 중 확인 : `Active: inactive (dead)`
### NginX 기본 화면 확인
  - `http://{ec2 ip 혹은 ec2 도메인}`으로 접속; 아래와 같은 화면
    ![image](https://github.com/hso8706/Useful/assets/103169947/7d7311f5-2300-4eef-a538-b3a8adde6da6)

## 2. Nginx 로 domain 연결하기
### Domina 생성(구매)
- 가비아 


## 3. Nginx 프록시 설정 추가하여 Spring boot 프로젝트 연결하기

## 4. Nginx 이용해서 SSL 인증 받기
  ![image](https://github.com/hso8706/Useful/assets/103169947/0db1648e-71f2-4d70-89ab-ee50779d67c5)