### 다양한 DB 중 Maria DB, Mysql
- 보통 많이 쓸 것으로 예상되기 때문
- 하지만 현업에서는 잘 안씀

### DBSM Tools
- MySQL workbench(잘안씀)
- HeidiSQL
- Toad for MySQL
- Orange
- Golden
- SQLGATE
- DBeaver

### Maria DB port(설치)
- MySQL: 3306
- Marid: 3305

### DBeaver에서 Maria DB 연결
- error
    RSA public key is not available client side (option serverRsaPublicKeyFile not set) RSA public key is not available client side (option serverRsaPublicKeyFile not set)
- 해결
  - DB 연결 시 Driver Properties에서 추가 설정
  - allowPublicKeyRetrieval : true
  - useSSl : false
  - 두 가지가 없을 경우에는 User Properties 부분에서 add new property로 직접 설정

### 같은 port 번호
    maria db를 연결할 때 실수로 port 3306(MySQL과 동일)을 사용했더니, 기존에 내 로컬 컴퓨터에 존재하던 MySQL 데이터 정보가 자동으로 따라오게 됨.

### maria db full backup(cmd 사용)
- cmd 관리자 실행
- maria db 설치 경로 및 bin 경로로 이동
    `C:\Program Files\MariaDB 11.2\bin>`
- 명령어 실행
    `mysqldump -u <사용자이름> -p --all-databases > <백업파일경로>\<파일명>.sql`
    - `mysqldump`: MariaDB와 MySQL에서 모두 사용할 수 있는 표준적인 데이터베이스 백업 도구
    - `-u` 플래그: db 서버에 접속할 사용자 이름 지정 (예. root)
    - `-p` 플래그: 비밀번호를 입력하라는 프롬프트를 표시
    - `--all-databases`: 모든 데이터베이스를 백업하라는 옵션
    - `>`: 결과물을 다른 파일로 저장할 때 사용
    - `<백업파일경로>\<파일명>.sql`: 결과물로 저장할 위치와 파일명 및 확장자 지정

### maria backup 데이터베이스 사용
- cmd 관리자 실행
- maria db 설치 경로 및 bin 경로로 이동
    `C:\Program Files\MariaDB 11.2\bin>`
- 명령어 실행
    `mariadb -u <사용자이름> -p < <백업파일경로>\<파일명>.sql`
    - 위와 모두 같지만 하나, `<`이 부분이 다름
    - 바뀐 방향 키워드가 sql 파일을 사용하여 database를 구성하게 만듬
    - `mariadb`: MariaDB 서버를 실행하기 위한 실행 파일 또는 명령어
    - `< <백업파일경로>\<파일명>.sql`: 백업된 데이터베이스 설정이 저장된 .sql을 읽고 mariadb 서버에 적용함

### maria db 특정 테이블 backup 및 사용
- cmd 관리자 실행
- maria db 설치 경로 및 bin 경로로 이동
    `C:\Program Files\MariaDB 11.2\bin>`
- 명령어 실행(백업)
    `mysqldump -u root -p <데이터베이스명> <테이블명> > <백업파일경로>\<파일명>.sql`
- 명령어 실행(사용)
    `mariadb -u root -p <데이터베이스명> < <백업파일경로>\<파일명>.sql`

### maria db log 파일을 sql 문서로 변환하기
- `C:\Program Files\MariaDB 11.2\data`경로에 존재하는 `my.ini` 파일 열기
- 파일 내 `[mysqld]`부분 내에 `log-bin=<파일명>`작성
  - `log-bin`: 바이너리 로그 활성화하고 해당 파일명으로 로그 파일을 생성시킴
  - 생성되는 로그 파일명은 `파일명.000001`, `파일명.000002` 순으로 생성됨
- 서버 재실행
- 명령어 실행
    `mysqlbinlog --database=<A> --start-datetime="<B>" --stop-datetime="<C>" "C:\Program Files\MariaDB 11.2\data\<D>" > <E>`
    - A: 데이터베이스 이름
    - B: 작업이 실행된 시간, 사용한 툴에 작성됨(예. 2023-06-30 11:40:39)
    - C: 작업이 종료된 시간
    - D: 로그 파일명
    - E: 파일명.sql