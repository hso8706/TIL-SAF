# Front 과목평가 대비

## 주요 태그와 속성들의 사용
## CSS 선택자
## CSS 박스 속성
## 부트스트랩 그리드 방식 이해
## CSS position, display의 이해
## Ajax 통신 특징
## JSON 사용, fetch()
## 자바스크립트의 엘리먼트 접근, 이벤트 핸들링
## 자바스크립트의 연산자, 자료형
## 호이스팅
## localStorage, sessionStorage 특징
## 파라미터 전송 방식 및 비동기 통신 데이터의 형식들에 대한 이해

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
- 태그 내부에 처리할 이벤트를 속성으로 붙임
- 