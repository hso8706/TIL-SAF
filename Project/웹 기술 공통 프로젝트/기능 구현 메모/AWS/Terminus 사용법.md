### 다운로드 및 설치
- 각자 OS에 맞게 다운로드 및 설치

### Key 생성
1. 톱니바퀴 설정
2. Keychain 탭 클릭
3. KEY 클릭(사진 참고)
![image](https://github.com/hso8706/TIL-SAF/assets/103169947/a1cc51a2-d563-4bbb-9632-7b675e6a7efc)
    - 꺽새가 아닌 KEY라고 적힌 버튼 클릭
4. Label 및 key file 추가
    - .pem 파일을 넣어주면 label 자동으로 완성됨

### Host 생성
1. 메인 화면의 Hosts 탭 클릭
2. NEW HOST 버튼 클릭(꺽새 아님)
3. 내용 작성
    - Label: 임의 작성
    - Address: 필수 작성, `i9a805.p.ssafy.io`
    - Username: ubuntu
    - Set a Key: 이전에 생성한 키, `I9A805T.pem`

### 연결
- 완성된 Host 더블 클릭

### 종료
- exit 명령어 입력