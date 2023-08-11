### Docker CLI 명령어

- docker image pull {레지스트리 주소}/{레지스트리 이름}:{Tag}
  - {레지스트리 주소} : Docker(== docker hub가 기본값)
  - {Tag} : 주로 버전 정보 입력, latest가 기본값

- docker image ls
  - image list 확인 명령어
  - 레포지토리, tag, image_id, 생성 일자, 용량

- docker container run --name {컨테이너 이름} {레지스트리 주소}/{레지스트리 이름}:{Tag}
  - docker container를 실행시키는 명령어

- docker container ls
  - container 목록 확인 명령어

- docker container rm
  - container 삭제 명령어

- docker image rm
  - image 삭제 명령어

- docker-compose up
  - docker-compose.yaml에 정의된 이미지를 컨테이너로 실행

- docker-compose down
  - docker-compose.yaml에 정의된 이미지를 컨테이너를 종료

- docker-compose up {특정 이미지}
  - docker-compose.yaml에 정의된 이미지 중 특정 이미지를 컨테이너로 실행

- docker logs {container 이름}
  - docker로 진행되는 프로세스의 로그를 확인하는 명령어

### 옵션
- --name : 컨테이너 이름 설정 옵션
- -p {local port}:{container port} : 로컬 호스트와 컨테이너 포트를 연결하는 옵션