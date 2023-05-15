# 23.05.15
### Vuex
- Vue.js application에 대한 상태관리패턴 + 라이브러리
- 데이터 관리하는 것이 유용해짐
- 데이터 중앙 저장소같은 개념이다
  - Vuex가 없다면 props, $emit을 사용하면서 관리해야하고 이는 불편함을 초래

### Vuex 컨셉
  ![image](https://github.com/hso8706/Algorithm_Trip_RunInto/assets/103169947/bdf8e67a-f1e9-4426-97cf-8686b10da92d)
  - Backend API
    - boot server
  - Vue Components
    - 화면(event 발생)
  - Actions
    - 비동기 작업
  - Mutations
    - 동기 작업
    - data 변경
  - State
    - data가 저장되는 위치
- 그림에 나타난 흐름도 기억
- 약간 스프링의 컨테이너 개념과 비슷해보임


## 실습
### vuex 설치
- `npm i --save vuex --force`
- 강제
### src/store
- vuex를 위한 공간
### src/util
- 작업의 편의를 위한 공간
- Constant.js
  - 가독성을 위한 파일
### 흐름도
- component => View => roter + App.vue => main.js
- /store/index.js
  - component들이 공유할 data가 저장된 장소
- /util/Contant.js
  - 변수를 선언한 장소
- main.js
  - App.vue 내용대로 화면(DOM) 생성
  - router 등록
  - store 등록

### components.vue 수정
  - 기존 import 제거
  - created() 내에서 this.$store.dispatch() 호출
### actions
  - 비동기 호출 로직을 처리하는 공간