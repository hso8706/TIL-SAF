### AWS RDS 인스턴스 생성 및 연결
1. DB 인스턴스 생성
2. 데이터베이스 연결

### DB 인스턴스 생성
1. AWS RDS 메인 화면 - 사이드바 데이터베이스 탭 - 데이터베이스 생성
2. 데이터베이스 엔진 유형 선택
3. 템플릿 옵션 선택
4. 연결 옵션 설정
   - DB 클러스터 식별자 이름 설정
   - 마스터 사용자 이름 설정: 로그인 ID
   - 마스터 암호 설정: 로그임 PW
   - 퍼블릭 액세스 기능: 예 설정
5. 보안 그룹 및 포트 번호 설정
   - VPC 보안 그룹: 기존 항목 선택
   - 기존 PC 보안 그룹: default 그룹 선택
   - 추가 연결 구성 - 데이터베이스 포트 설정: 포트 번호 노출 방지 목적으로 13306 설정
6. 추가 구성 토글
   - 초기 데이터베이스 이름 설정: 서버 코드에서 사용할 db 이름

### 데이터베이스 연결(MySQL 기준)
- 필요 정보
  - DB 인스턴스의 마스터 이름, 마스터 암호
  - 포트 번호
  - DB 인스턴스의 엔드 포인트
    - DB 인스턴스 클릭 후 연결&보안 탭에서 확인 가능
- 연결 명령어
```
mysql -u {마스터 이름} --host {엔드 포인트 주소} -P {포트 번호} -p
Enter password: {마스터 암호}
```
- 확인 명령어
```
show databases;
// 설정한 데이터베이스 이름과 같은 데이터베이스가 있다면 성공
```

### 서버와 RDS 연결
1. EC2 인스턴스 터미널 오픈(서버가 실행되고 있다면 종료, ctrl+c)
2. .properties(혹은 .yml) 파일 설정
   - 방법1. 설정 파일있는 경로로 이동해서 nano editor로 설정 변경하기(변경 후 ctrl+x 로 저장)
   - 방법2. 배포용 설정 파일 만들기
3. 빌드 삭제 후 재 빌드
   - 빌드 삭제: `./gradlew clean` 
   - 빌드 생성: `./gradlew build`
4. 서버 실행
   - `java -jar build/libs/{스냅샷}.jar`
   - shell script로도 가능

### .properties 설정
```properties
spring.jpa.database=mysql
spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect
spring.datasource.url=jdbc:mysql://{AWS RDS 엔드포인트}/{DB 이름}?useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC
spring.datasource.username={AWS RDS 마스터 이름}
spring.datasource.password={AWS RDS 마스터 암호}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
config.domain={AWS RDS 엔드포인트}
```
- dialect
    jpa는 여러 database를 지원하기 때문에 표준화된 인터페이스를 지원함.
    따라서 database의 특정 부분이 조금씩 다를 수 있음.
    이를 jpa와 database 사이에서 올바르게 변환시키기 위한 옵션

- SSL
    Secure Sockets Layer의 약자.
    웹 브라우저와 웹 서버 간의 데이터 통신을 암호화하는 프로토콜.
    데이터를 안전하게 전송하고 외부의 불법적인 열람이나 변경을 방지하는데 사용.
    
### .yml 설정
```yml
spring:
  jpa:
    database: mysql
    database-platform: org.hibernate.dialect.MySQL5InnoDBDialect
  datasource:
    url: jdbc:mysql://{AWS RDS 엔드포인트}/{DB 이름}?useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC
    username: {AWS RDS 마스터 이름}
    password: {AWS RDS 마스터 암호}
    driver-class-name: com.mysql.cj.jdbc.Driver
config:
  domain: {AWS RDS 엔드포인트}
```