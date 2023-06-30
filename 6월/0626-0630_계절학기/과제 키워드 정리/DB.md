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

### Maria DB port
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
    - `-u` 플래그: 사용자 이름 지정
    - `-p` 플래그: 비밀번호를 입력하라는 프롬프트를 표시
    - `--all-databases`: 모든 데이터베이스를 백업하라는 옵션
