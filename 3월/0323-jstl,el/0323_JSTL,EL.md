# 23.03.23

## EL, JSTL
### JSP 페이지 구성요소
1. 지시어 원소
2. 스크립팅 원소
   1. 선언
   2. 식
   3. 스크립트렛
   4. 식언어(EL: Expression Language)
3. 액션 원소

### EL
- `${표현식}`
- JSP 페이지 내의 객체를 쉽게 접근하기 위한 언어
- 해당 표현식을 실행하고 출력할 뿐, 큰 기능이 없음
- 때문에 주로 jstl과 같이쓰임

### 표현 예시
- jsp
  - `<%= request.getParameter("num") %>`
- jstl
  - `<c:out value = "${param.num}"/>`
- EL
  - ${param.num}

### EL 연산자
- 자바와 거의 같음
- 새로운 연산자
  - eq, ne : equal, not equal
  - lt gt : less than, greater than
  - le ge : lt & equal, gt & equal
  - empty : 공백 연산자

### EL의 디폴트 객체(내장 객체, 소문자로 시작)
- pageContext
- Scope
  - pageScope
  - requestScope
  - sessionScope
  - applicationScope
- param : http의 파라미터들
- paramValues
- header
- headerValues
- cookie
- initParam

### JSTL
- 표준화된 태그 라이브러리
- jsp 문서는 결국 HTML, JSP tag, JSTL tag 로 결국 구성될 예정
- jsp에서 기본적인 기능은 제공하지만 부족함
- 그래서 많이 쓰이고 표준화 할 만한 태그를 만들어서 jstl이라는 명칭으로 제공하는 것

### JSTL 태그 카테고리
- Core : Page 작성에 필요 => 핵심 기능, 주로 쓸 태그들
  - 우리는 jsp를 view로 쓸 예정이므로 Core만 쓴다.
- I18N : Format 지정 태그
- SQL : DB 관련 태그
- XML : XML 관련 태그

