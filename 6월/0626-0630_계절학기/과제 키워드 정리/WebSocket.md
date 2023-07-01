# WebSocket

### WebSocket 통신
- 클라이언트와 서버를 연결하고 실시간 통신이 가능하도록 하는 기술
- HTTP 통신 프로토콜과 같이 프로토콜 중 하나

### 기존 HTTP 통신과의 차이
- 기존 HTTP 통신
  - 서버에서 클라이언트로 데이터를 전송하기 위해서는 반드시 요청이 우선시 되어야함.(== 능동적인 데이터 전송 불가)
- WebSocket 통신
  - 별도의 요청 없이도 클라이언트가 데이터를 수신할 수 있음.

### WebSocket의 필요성
- 지속적으로 업데이트되는 정보를 수신해야하는 경우 사용
  - 예시1. 채팅
  - 예시2. 주식 보고서

### WebSocket의 특징
- 정보를 동시에 송수신할 수 있어서 정보 교환이 빠름(정보 양방향 교환)
- 클라이언트 혹은 서버가 종료되기 전까지 열린 상태로 존재
- 클라이언트 혹은 서버가 시간 초과에 의해 닫히기 전까지 열린 상태로 존재
- 데이터 암호화 가능

### WebSocket 통신 사용 예시
- 교환 플랫폼
- 채팅 앱
- 푸시 알림
- 소셜 네트워크
- IoT 앱

## 구현. WebSocketTest
### 준비 단계
- Node.js 설치
  - 설치 확인: `node -v`
- `npm init` 명령어 실행
  - node.js 패키지 매니저
  - package.json 생성
- `npm i express` 명령어 실행
  - express.js 설치
- package.json에 명령어 추가
  - "script"부분에 "dev": "nodemon index.js" 추가
  - `nodemon`: Node.js 애플리케이션에 변화가 생겼을 경우 자동 감지 및 적용 후 서버를 재시작해주는 도구
  - `index.js`: nodemon으로 관리할 파일
  - `dev`: `nodemon index.js`를 실행할 키워드
  - 위와 같이 작성 후 `npm run dev`를 실행하면 nodemon으로 index.js를 관리하며 서버가 실행된다.
### 패키지 구조 및 코드 설명
- 상세 설명은 주석으로 메모
- front
  - 화면으로 만들 정적페이지를 담을 패키지 경로
- front/index.html
  - 화면으로 사용할 정적페이지