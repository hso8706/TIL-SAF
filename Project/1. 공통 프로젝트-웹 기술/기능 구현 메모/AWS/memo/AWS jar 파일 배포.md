# BUILD

### Build 기본

- gradle 혹은 maven 중 어떤 것의 기반을 둔 애플리케이션지 확인
- 기반을 둔 빌드 툴(gradle, maven)을 기반으로 소스 코드를 빌드
- build의 목표는 IDE의 힘을 빌리지 않고 해당 소스 코드를 실행시키기 위함.

### Build 방법

1. IDE(IntelliJ)를 이용한 build
2. 터미널에서 명령어를 이용한 build

### IDE(IntelliJ) 이용하기

- 방법
    - `Gradle 탭` - `Tasks` - `build` - `bootJar` 혹은 `build`
- `bootJar`와 `build`의 차이
    - bootJar
        - 오로지 애플리케이션의 실행 가능한 Jar 파일, 즉 Executable Jar 파일을 생성하기 위한 Tasks만 실행한다.
    - build
        - Executable Jar 파일을 위한 Tasks 외에도 :assemble , :check 같이 Gradle에서 빌드와 관련된 모든 tasks를 실행한다.
        - Executable Jar 파일 외에도 Plain Jar 파일을 생성한다.

### OS의 터미널에서 명령어를 이용한 build

- 방법
    1. 터미널을 키고 build를 원하는 프로젝트의 root 경로(gradlew이 존재하는)로 이동한다.
    2. `./gradlew build` 혹은 `./gradlew bootJar` 사용
    3. `root 경로/build/lib` 경로에 .jar 파일 생성

# COMPILE

### Complie 조건

- .jar 파일 필요
- JVM 설치 필요

### Complie 방법

- 실행
    1. 터미널에서 프로젝트의 root 경로에 있는 `build/lib` 경로로 이동
    2. 명령어 실행
        
        ```
        java -jar {jar 파일명.jar}
        
        ```
        
    3. 기존 IDE에서 뜨는 로그가 뜨면서 진행되면 성공
    4. 종료는 ctrl + c (windows powerchell 기준)
- profile 명령어
    - 적용해야하는 profile 명령어가 있다면 .jar 파일명 뒤 명령어에 작성해야할 부분
    - `-spring.profiles.active={profile 이름}`
        
        ```
        java -jar {jar 파일명.jar} {profile 명령어}
        
        ```
        

# DEPLOY

### 배포 방법

1. 고전 방법
    - scp나 sftp 같은 표준 유닉스 툴을 이용해서 (JVM이 설치된)서버로 jar 파일 전송 후 해당 서버에서 jar 실행하기
2. cloud 이용하기
    - IaaS
    - PaaS
    - CI/CD

### 배포

- 개발한 서비스를 사용자가 이용가능하도록 만드는 과정

### 배포 4단계

1. Deployment
    - 개발 단계
    - 각자 local 컴퓨터에서 코딩 및 테스팅하는 단계
2. Intergration
    - 취합 단계
    - 각자 local에서 짠 코드를 합치는 과정, 상호 코드 간 침범으로 인해 발생하는 error 혹은 conflict를 잡는 과정
3. Staging
    - 출시 전 마지막 확인 단계
    - 실제 데이터를 사용하거나 실제 운영 환경 등의 다양한 환경에서 테스팅하고, 연관 관계에 있는 다른 부서의 확인까지 거치는 단계
4. Production
    - 출시 단계
    - 코드를 구동하여 사용자들이 서비스를 이용할 수 있는 단계

### 환경의 차이

- Deployment 환경과 Production 환경은 다를 수 밖에 없음
- 때문에 환경 설정을 코드와 분리하는 것이 중요

### 환경의 차이를 극복하기

1. 절대경로 대신 상대경로 사용하기
2. 환경에 따라 포트를 분기할 수 있도록 환경변수를 설정
3. Docker 사용하기
    - Docker를 사용한다면 모두의 개발 환경 자체를 통일시킬 수 있음