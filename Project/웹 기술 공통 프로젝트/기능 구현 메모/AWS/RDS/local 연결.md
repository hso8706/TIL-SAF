### Maria DB 설치

### mysql client 연결
- mysql -h {AWS RDS 엔드포인트} -P {포트번호} -u {AWS RDS 마스터 이름} -p

### mysql workbench 연결
![image](https://github.com/hso8706/TIL-SAF/assets/103169947/6f33bdf9-10d0-46af-8773-1942883173d5)
- connection name : 임의명
- host name : {AWS RDS 엔드포인트}
- port : {aws rds port num}
- username : {AWS RDS 마스터 이름}
- password : {AWS RDS 마스터 암호}

### spring boot jpa 연결
- gradle
    ```
    // MariaDB 데이터베이스 드라이버 추가
    implementation 'org.mariadb.jdbc:mariadb-java-client:2.7.3'
    ```
- yml
    ```yml
    spring:
        datasource:
            url: jdbc:mariadb://{AWS RDS 엔드포인트}:{port num}/{db 이름}?useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC
            username: {AWS RDS 마스터 이름}
            password: {AWS RDS 마스터 암호}
            driver-class-name: org.mariadb.jdbc.Driver
    jpa:
        database-platform: org.hibernate.dialect.MariaDBDialect
    ```