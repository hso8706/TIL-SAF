# 23.03.15
## Index 
1. 반응형 웹
2. Bootstrap

## 1. 반응형 웹

### 반응형 웹 장점
- 모든 스마트 기기에서 접속 가능
- 가로 모드에 맞추어 레이아웃 변경 가능(반응형은 가로를 기준으로 한다.)
- 사이트 유지 관리 용이 : 하나의 코드로 여러 기기에 적용

### 뷰포트
- 뷰포트를 지정하면 접속한 기기 화면에 맞추어 화면을 출력할 수 있다.
- 뷰포트는 스마트폰 화면에서 실제 내용이 표시되는 영역을 말함.
- 보고있는 화면을 말함
- 상대적인 크기를 조절함
```javascript
// 뷰포트 지정
<meta name="viewport" content="[속성1=값], [속성2=값], ...">
```

### 뷰포트 속성
- width
- height
- user-scalable
- initial-scale
- minimum-scale
- maximum-sclae

## 2. BootstrapE

### Bootstrap
- 프론트 엔드 프레임 워크
- Grid

### Bootstrap 장점
- 사용 난이도 낮음
- 반응형 기능
- 모바일 우선 접근 방식
- 브라우저 호환성

### Bootstrap 단점
- CSS가 제한적임
  - 정해진 변수만 사용할 수 있음
  - Sass라는 것으로 부족한 변수를 사용자 설정으로 추가할 수 있음.

### Breakpoint
- 반응형을 만들기 위해서 6개의 breakpoint를 제공함

### Container
- 큰 틀 개념
- container 종류
  - container
  - container-md
  - container-fluid

### Grid System
- 최대 12개의 열을 허용하는 화면 구분 시스템

### 참고 링크
- W3School : [https://www.w3schools.com/bootstrap5/index.php]
- Bootstrap : [https://getbootstrap.com/docs/5.3/getting-started/introduction/]

### layout
 - 화면에서의 배치