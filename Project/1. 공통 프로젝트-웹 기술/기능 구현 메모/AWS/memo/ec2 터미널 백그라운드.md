### 백그라운드 실행
- `nohup`, `&`
  - `nohup` : 터미널을 꺼도 애플리케이션이 꺼지지 않도록 하는 명령어
  - `&` : 애플리케이션이 백그라운드에서 돌아갈 수 있는 명령어
- 풀 명령어
```
nohup java -jar {파일명.jar} &

java -jar BackEnd-0.0.1-SNAPSHOT.jar
nohup java -jar BackEnd-0.0.1-SNAPSHOT.jar &


nohup: ignoring input and appending output to 'nohup.out' // 이 명령어가 뜨면 성공
```

### 백그라운드 확인
- 명령어
  - `ps`
- 옵션
  - `-e` : 백그라운드 외 모든 프로세스 확인
  - `-f` : 프로세스 상세 보기
- 실사용
  - ec2를 백그라운드에서 실행시키고 터미널 혹은 terminus를 종료한 경우, ps 명령어로만은 안보인다
  - `ps -ef`를 사용해서 전체 프로세스를 확인하고 실행되는 프로세스를 찾아 프로세스 id를 정확히 기입할 것

### 프로세스 종료
- `kill -9 [프로세스 id]`
  
### 백그라운드 로그 확인
- `tail -f nohup.out`

### 사용하는 포트 확인
- `lsof -i :{포트 번호}`
- `netstat -tuln`

### ip 확인
- `curl ifconfig.me`