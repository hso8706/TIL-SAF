# Front 과목평가 대비

- 주요 태그와 속성들의 사용
- CSS 선택자
- CSS 박스 속성
- 부트스트랩 그리드 방식 이해
- CSS position, display의 이해
- Ajax 통신 특징
- JSON 사용, fetch()
- 자바스크립트의 엘리먼트 접근, 이벤트 핸들링
- 자바스크립트의 연산자, 자료형
- 호이스팅
- localStorage, sessionStorage 특징
- 파라미터 전송 방식 및 비동기 통신 데이터의 형식들에 대한 이해

### 속성 선택자
- 특정한 값으로 시작하거나, 포함된 속성값을 지닌 엘리먼트를 호출하는 선택자
- 종류
    - `[A]` : A 속성을 지닌 엘리먼트를 선택
    - `[A=V]` : A 속성을 지니고, 동시에 A 속성값이 V인 엘리먼트를 선택
    - `[A~=V]` : A 속성을 지니고, 동시에 A 속성값이 V라는 단어를 포함하는 엘리먼트를 선택(단어를 통째로 지녀야하는 듯)
    - `[A^=V]` : A 속성을 지니고, 동시에 A 속성값이 V로 시작하는 엘리먼트를 선택
    - `[A*=V]` : A 속성을 지니고, 동시에 A 속성값이 V를 포함하는 엘리먼트를 선택
    - `[A$=V]` : A 속성을 지니고, 동시에 A 속성값이 V로 끝나는  엘리먼트를 선택
    - `[A|=V]` : A 속성을 지니고, 동시에 A 속성값이 정확히 V이거나, V-로 시작하는 엘리먼트를 선택

### 호이스팅
- 정의
  - 변수(var) 혹은 함수(funcion)이 선언되기 이전에 참조가 가능한 특성을 의미함
  - 모든 `선언문`은 호이스팅이 된다.
- 종류
  - 변수 호이스팅
  - 함수 호이스팅
### 변수 호이스팅
- Javascript 변수
  - var 키워드 사용
  - var 키워드를 사용한 변수는 같은 변수명으로 중복하여 선언이 가능함.
- 변수의 생성
    1. 선언 : 변수 객체에 변수를 등록
    2. 초기화 : 변수 객체에 등록된 변수를 메모리에 할당. 이때, undefined로 초기화 됨.
    3. 할당 : undefined로 초기화된 변수에 값을 할당
    - 1,2 번은 한 번에 이루어지는 단계이다.
- 변수 호이스팅
  - 코드 순서상 선언되지 않은 변수를 사용하더라도 undefined된 변수가 호출됨.
### 함수 호이스팅
- Javascript 함수
    - 일급 객체(first-class)임
    - 함수를 변수, 객체, 배열, 매개변수, 리턴 값 등 사용 가능
- 함수 정의 종류(3가지)
    - 함수 선언문 : `function 함수명(매개변수){};`
    - 함수 표현식 : `var 함수명 = function(매개변수){};`
    - funtion 생성자 사용 : `var 함수명 = new function(매개변수){};`
- 함수 선언문
    - 함수 선언문 방식으로 함수를 정의한 경우, javascript가 로딩되는 시점에 변수 객체에 저장함.
    - 함수 선언, 초기화, 할당이 동시에 이루어짐
- 함수 호이스팅
  - 코드 순서상 선언되지 않은 함수를 사용하더라도 정의된 함수를 사용할 수 있음.
  - 하지만 이는 과도할 경우 성능 저하를 유발할 수 있음.
  - 함수 표현식으로 정의된 함수는 함수 호이스팅이 아닌 변수 호이스팅 취급되어 선언전에 사용할 수 없음.

### HTML 객체 가져오기
- `querySelector()` & `querySelectorAll`
  - `querySelector(selector)` : selector에 일치하는 **첫번쨰** elements 객체를 얻음
  - `querySelectorAll` : selector에 일치하는 **모든** elements 객체를 얻음
- `getElementBy~` & `getElementsBy~`
  - `~` : `Id`, `ClassName`, `TagName`, `Name`을 넣을 수 있음.
  - 단수냐 복수냐의 차이
  - Id는 유일하기 때문에 단수를 사용하고, 나머진 복수를 사용한다.

### `==`과 `===`의 차이
- `==` : 값만 확인
- `===` : 변수 타입까지 확인

### 비동기 통신으로 받아오는 데이터 형식의 특징들(서술형각)
- data 형식의 통일
  - server와 client의 통신을 위해서 data 형식을 통일한다.
- 통신을 위한 data 형식
  - CSV; Comma Separated Values
    - comma(,)로 데이터를 구분하여 표현하는 형식
    - CSV 특징
      - 다른 두 형식에 비해 길이가 짧아서 많은 양의 데이터를 전송하는데 유리하다.
      - 각각의 데이터가 어떤 내용인지 파악하기 힘들다. (server와 client가 완벽히 같은 데이터 구조를 공유하면 가능)
      - head의 contentType이 `text/plain`이다.
  - XML; eXtensible Markup Language
    - tag로 데이터를 구분하여 표현하는 형식
    - XML 특징
      - tag를 통해 각 data가 무엇을 표현하는지 파악 가능
      - 사용자 정의 속성도 tag에 넣을 수 있으므로 복잡한 data도 전달 가능함.
      - head의 contentType이 `text/xml`이다.
  - JSON; JavaScriptObject Notation
    - JavaScript에서 사용하는 객체의 형식으로 데이터를 표현하는 형식
    - CSV와 XML의 단점을 극복한 케이스
    - 통신(AJAX 등)을 위한 데이터 형식 중 거의 표준으로 사용하는 형식
    - JSON 특징
      - 텍스트 기반이라 상당히 가벼움
      - 읽기 편함
      - key-value 쌍으로 저장
      - 직렬화(serialize)와 역직렬화(deserialize)를 통해 데이터 주고 받음
      - 프로그램 언어나 플랫폼에 독립적

### form 태그
- form control
  - 사용자의 입력을 받아 server에 정보를 넘기는 것
  - 이를 위한 태그들과 속성들이 존재(엄청 많음)
- form 태그의 속성
  - method : 사용자 입력값을 get으로 전달할 지, post로 전달할 지를 지정
  - name : form 태그의 이름을 지정
  - action : 사용자 입력값을 처리할 서버 프로그램을 지정, URL 입력
  - target : action 에서 지정한 스크립트 파일을 현재 창이 아닌 다른 위치에서 열도록 지정
  - autocomplete : 자동완성 기능, default=on

### GET 방식과 POST 방식의 차이
- GET 방식
  - get으로 요청을 전송하면 주소창에 query parameter에 요청으로 보낸 정보들이 다 보임.
  - 보안에 취약하고 데이터를 많이 보내기 불리함
- POST 방식
  - post으로 전송 시에는 주소창에 parameter에 보낸 정보들이 보이지 않음
  - 보안에 비교적 강하고, 많은 양의 데이터를 보내기 유리함

### 문서별 주석 차이
- html: <!-- -->
- css : /* */
- js: //

### HTML 블럭 요소와 인라인 요소
- 블럭 요소
  - 독립적인 덩어리 공간을 갖는 HTML Elements
  - `<div>,<table>,<h1>~<h6>,<p>,<form>,<ul>,<ol>,<li>,<nav>,<section>,<dl>,<dt>,<dd>,<pre>,<blockquote>`등
- 인라인 요소
  - 행 안의 일부처럼 다른 태그와 나란히 위치되는 HTML Elements
  - `<span>,<a>,<br>,<em>,<strong>,<input>,<label>,<img>`

### event 처리 종류 3가지
- 이벤트 핸들러(이벤트 리스너)
  - : 이벤트를 감지하고 대응하여 처리하는 작업을 등록하는 것을 의미
- 1. 인라인 이벤트 핸들러
  - : HTML 요소 내부에 직접 이벤트 핸들러 등록
  - : onclick, mouseover 따위의 속성을 직접 HTML 요소에 붙이던 것
- 2. 이벤트 핸들러 프로퍼티 방식
  - : 자바스크립트 코드 내부에서 이벤트 대상이 되는 특정 DOM을 선택하고, 거기에 이벤트 핸들러를 등록하는 방식
  - 예시. document.getElementById("event1").onclick = function(){};
  - : 특정 프로퍼티에 여러 이벤트 핸들러를 덧붙일 수 없음. 즉, 마지막에 바인딩된 이벤트 핸들러만 적용(코드 순)
- 3. addEventListener 메소드 방식
  - : 3개의 전달 인자로 세밀한 이벤트 제어가 가능
    - 인자 1: 이벤트 이름(전치사 제거)
    - 인자 2: 이벤트 핸들러
    - 인자 3: 캡쳐링, 버블링 여부(optional, true==캡처링, false==버블링)
  - : 하나의 이벤트에 하나 이상의 이벤트 핸들러를 중복하여 사용할 수 있음.
  - : 캡처링 지원(부모 HTML 요소부터 이벤트 근원지인 자식요소까지 검사)
  - : 버블링 지원(이벤트 발생 요소부터 부모 요소까지 올라가며 검사)

### change event
- `<select>`박스, type = check, type = radio에 주로 쓰임
- 사용자가 해당 체크 공간의 상태를 변경할 시 발생하는 이벤트

### local storage, session storage
- web storage
  - `key`, `value`의 쌍으로 데이터를 저장
  - `local storage`와 `session storage`가 있음
  - 값은 `문자열`로 저장되며, 도메인과 브라우저 별로 저장됨.
- local storage
  - 사용자 로컬에 데이터를 저장하는 방식
  - 자바스크립트로만 조작
  - 영구적인 데이터 저장(컴퓨터를 껐다 켠들 브라우저에 남아있음)
  - 도메인만 같으면 전역적으로 공유 가능함
  - 문자열의 데이터만 저장할 수 있기 때문에 직렬화(.stringify())필수
- session storage
  - 현재 떠있는 탭의 세션에서만 유지되는 데이터 저장 방식(같은 세션에서만 사용 가능)
  - 새로고침에는 데이터가 유지되지만, 탭을 종료하면 사라짐
  - 같은 사이트, 같은 도메인이라도 브라우저(탭)이 다르면 다른 영역(세션)으로 인식

### 직렬화, 역직렬화
- 데이터 객체와 문자열을 서로 변경하는 과정을 의미함.
- 직렬화는 객체를 문자열로, 역직렬화는 문자열을 객체로 변경하는 것
- 예시
```javascript
  let user = {
      name: "길동맨",
      job: "의적"
  };
  let userinfo = JSON.stringify(user);
  console.log(userinfo); // {"name":"길동맨","job":"의적"}
  console.log(typeof userinfo); // string
  let backToUser = JSON.parse(userinfo);
  console.log(backToUser); // {name: '길동맨', job: '의적'}
  console.log(typeof backToUser); // object
```

### Window 객체
- 의미 및 특징
  - javascript의 최상의 전역 객체
  - BOM(Browser Object Model)이라고도 함
  - window 객체를 호출하는 것은 브라우저에서 제공하는 창을 호출하는 것이다. (현재 기준(?))
- window 객체 메서드
  - window.는 생략하기도함
  - window.alert() : 브라우저의 알림창
  - window.confirm() : 브라우저의 확인/취소 선택 창
  - window.prompt() : 브라우저의 입력창
  - window.open() : 새 창 열기
  - window.close() : 현재 창 닫기
  - 이거말고도 엄청 많음. 다른거 나오면 틀림
- opener 객체
  - 새 창을 연 창, 즉 부모 창을 컨트롤하기 위한 객체
- navigator 객체
  - 브라우저 정보가 내장된 객체로, 브라우저를 구분하여 개별 작업을 위해 사용

### fetch() 함수
- fetch()
  - http 요청과 응답을 처리하는데 쓰이는 함수
  - 브라우저가 제공
- fetch(1, [2]);
  - 1: url 형식의 인자 제공
  - 2: get 혹은 post 선택, optiona이므로 default는 get 방식이다.
  - 반환 타입 : Promise 타입 
    - Promise.text() : 응답의 text를 반환
    - Promise.json() : 응답을 JSON으로 반환
    - Promise.formData() : 응답을 FormData로 반환
    - Promise.blob() : 응답을 BLOB 형태로 반환
- then()
  - fetch() 메서드에 체인 형식으로 붙여 사용하는 메서드로, fetch()가 성공적으로 Promise 반환값을 반환했을때 실행되는 메서드
- get, post
  - get : 200 ok
  - post : 201 creat

### bootstrap 기본 특징
- bootstrap을 사용하면 기본적으로 하나의 row를 12개의 col으로 나누어 사용한다.

### AJAX 통신
- AJAX
  - XMLHttpRequest(XHR) 객체로 데이터를 서버에 전달하고 비동기 방식으로 결과를 조회하는 구현 방식
- 일반 요청 응답과 Ajax 요청 응답
  - 일반 요청 응답
    1. data 입력 후 이벤트 발생
    2. 서버로 data 전달
    3. 내부 logic으로 data 처리
    4. data 처리 결과 응답 페이지를 생성
    5. client로 전달 
  - Ajax 요청 응답
    1. data 입력 후 이벤트 발생
    2. 서버로 data 전달
    3. 내부 logic으로 data 처리
    4. data 처리 결과를 Text, XML, JSON으로 응답
    5. 응답 데이터를 이용하여 필요한 부분만 동적으로 화면 재구성