# 23.03.22

## Index
1. Model1
2. MOdel2 (MVC Pattern)
3. Cookie
4. HttpSession

## Model1
### Model 구분
- JSP를 이용하여 구성할 수 있는 Web application architecture은 크게 model1, model2로 구분됨.
- 구분 기준 client request에 대한 logic 처리와 response page(view)에 대한 처리 중 어디에 집중하는지가 기준
  - client request에 대한 logic 처리와 response page(view)에 대한 처리 모두 함
  - response page(view)에 대한 처리만 함

### Model1
- `Model - (View + Controller)`
- view와 logic을 jsp 페이지 하나에서 처리하는 구조
- 구성
![jsp model1](https://user-images.githubusercontent.com/103169947/226771518-ae3bcd0f-fde5-44c8-8d34-2dc8d7de6b9d.PNG)

### Model1 장단점
- 장점
  - 구조가 단순하고 직관적임
  - 학습 난이도가 낮음
  - 개발 비용이 적게듬(시간 등)
- 단점
  - view(html) 코드와 로직 처리를 위한 java 코드가 섞여있어서 복잡함(jsp 코드 자체가 복잡해짐)
  - 백엔드와 프론트의 분업이 힘듬
  - 코드의 복잡도 때문에 유지보수가 어려움(프로젝트 규모가 클 수록 더 불리)
  - 확장성이 안 좋음

## Model2
### Model2
- `Model - View - Controller`
- Controller
  - client 요청, 응답에 대한 처리만 담당
  - servlet으로 해결(요청을 받고, 응답을 제공함)
- Model
  - service logic에 대한 처리만 담당
  - java class로 해결(service, dao, java beans)
- View
  - 출력될 화면에 대한 처리만 담당
  - jsp로 해결(logic 처리 코드는 없고, 결과 출력을 위한 코드만 존재)
- 구성
![jsp model2](https://user-images.githubusercontent.com/103169947/226772430-3c8c85f7-2ca9-4f19-a9f9-e7216d75e2d6.PNG)

### Model2 구조의 장단점
- 장점
  - view(html) 코드와 로직 처리를 위한 java 코드가 분리되어 있음(jsp 코드가 model1에 비해 단순)
  - 분업 용이
  - 유지보수 용이
  - 확장성 굳
- 단점
  - 구조가 복잡하여 학습 진입 장벽이 높은편
  - 개발 비용 증가(시간 등)

## Cookie
### http protocol
- stateless
  - client에 대한 요청을 처리하고 응답을 제공하면 연결 해제
  - 자원 낭비를 최소화하기 위해서
- stateless 단점
  - 사용자 정보가 유지되지 않음(예시. 로그인이 유지되지 않음)
- stateless 극복
  - Cookie와 Session을 이용하여 극복
  - Cookie의 단점을 극복하려는 노력이 Session

### Cookie
- cookie // cookie & session 다시 공부할 것. 내용이 꼬임
  - 서버가 웹 브라우저에 정보를 저장하고 불러올 수 있는 수단
  - 클라이언트에 존재하는 저장소 개념
  - 삭제하지 않으면 영구히 유지됨(장기 보관에 좋음, coockie 만료일을 설정할 수 잇음)
  - 사용자의 승인을 받지 않고도 보통 사용됨(요새는 승인 요청하는 웹 페이지들이 보이긴함)
  - 브라우저마다 cookie가 다름
  - header 부분에 정보를 담아서 요청, 응답에 주고 받음
  - `javax.servlet.http.Cookie`
- cookie 단점
  - 클라이언트에 정보를 저장하는 것이기 때문에 인증 상 한계 존재
  - http header에 개인 정보가 존재하기 떄문에 보안에 취약할 수 있음(다양한 옵션으로 어느 정도는 극복이 되긴 함)
- cookie 사용 목적
  - 세션 관리(아래 세션 설명 참조)
  - 트래킹 및 개인화: 사용자의 행동, 패턴을 기록하여 나중에 분석에 사용
- cookie 과정
  - client의 요청
  - WAS가 cookie 생성 및 응답 header에 cookie 포함하여 보냄
  - client(browser)는 cookie를 저장하고 이후 요청에 해당 cookie를 전송

### session
- 의미
  - 클라이언트와 서버 간의 연결 상태
  - 브라우저가 서버에 접속하고, 접속을 종료하기 전까지의 상태
  - 창을 닫으면 세션 종료
- session 과정
  - 로그인 요청(client => server)
  - 비밀번호 해싱 및 DB 조회
  - 세션 id 생성 (세션 스토어-server)
  - 쿠키 설정 + 세션 id 전달 (헤더 쿠기에 세션id를 포함하여 응답으로 client에 전달)
  - 브라우저(client) 쿠키에 세션id 저장
  - 이후로 브라우저(client)가 서버에 요청을 보낼 때마다 세션id를 함께 전달
  - 세션 스토어(세션 저장소)에서 해당 세션id를 조회 및 확인
  - 검증이 완료되면 요청에 대한 응답 처리 실시

