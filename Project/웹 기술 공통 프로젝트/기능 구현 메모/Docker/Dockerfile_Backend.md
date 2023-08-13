# Docker를 이용한 Spring boot Project 배포

### 1. Docker 이미지 빌드 설정 만들기
```
FROM azul/zulu-openjdk:17.0.7

WORKDIR /app

COPY ./build/libs/BackEnd-0.0.1-SNAPSHOT.jar /app

CMD java -jar BackEnd-0.0.1-SNAPSHOT.jar
```

- `FROM azul/zulu-openjdk:17.0.7`
  - base image 설정
  - `azul/zulu-openjdk:17.0.7`를 사용하는 image임을 지정하는 설정

- `WORKDIR /app`
  - 컨테이너 내에서 작업 디렉토리(work directory)를 설정
    - 작업 디렉토리란, 컨테이너 내에서 명령어가 실행될 때 기본으로 삼는 경로를 의미
  - 작업 디렉토리 사용 목적에 대한 추가 스터디 필요

- `COPY ./build/libs/BackEnd-0.0.1-SNAPSHOT.jar /app`
  - `./build/libs/BackEnd-0.0.1-SNAPSHOT.jar` 경로 내 파일을 `/app(작업 디렉토리)`에 복사하는 설정

- `CMD java -jar BackEnd-0.0.1-SNAPSHOT.jar`
  - CMD에서 해당 jar 파일을 실행시키는 명령어 설정

### 2. Dockerfile build 하기
- `docker build -t {docker hub 사용자명}/{docker hub 레포지토리명}:{구분자 혹은 버전} {dockerfile 경로}`

### 3. Docker login 및 push
- `docker login`
  - 도커 로그인 명령어
- `docker push {docker hub 사용자명}/{docker hub 레포지토리명}:{구분자 혹은 버전}`
  - 원하는 도커 레포지토리에 푸쉬하는 명령어

### 4. Docker pull
- `docker pull {docker hub 사용자명}/{docker hub 레포지토리명}:{구분자 혹은 버전}`
  - 원하는 도커 레포지토리에서 원하는 이미지 pull받는 명령어

### 5. 도커 실행
- `docker run -d --name {container name} -p {host port}:{container port} {docker hub 사용자명}/{docker hub 레포지토리명}:{구분자 혹은 버전}`