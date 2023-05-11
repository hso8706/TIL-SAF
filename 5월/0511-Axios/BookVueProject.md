# 23.05.11

## BookVueProject
- backend server

### mapper
- 쿼리 존재

### Controller
- @CrossOrigin
- @RequestMapping
  - 클래스 단위도 사용 가능

## bookrouter
- frontend server

### src/axios/axios-common.js
- axios 사용할 때, 중복되는 코드를 모아놓은 파일
- axios.create()
  - 기본 axios 객체에 사용자 설정을 더 추가해주기 위한 메소드
  - 주로 인자로 json을 제공
- export default
  - 외부 코드에서 import 해서 사용할 수 있게 하기 위함
  - `import {name} from {상대 경로}`

### axios.create()
- baseURL
  - 중복되는 기본 URL을 지정
- headers
  - Server로 제공되는 Content-Type을 지정