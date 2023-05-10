# 23.05.10
### Router
- SPA에서 화면 이동 효과를 사용할 수 있게 하는 기능
  - 라우터는 화면 이동을 위한 링크이다!
- `<router-link>` 태그로 기능 사용
- 이동되는 화면은 각각의 component로 대체한다.

### Router tags
- `<router-link>`
  - 화면 이동을 위한 링크를 만드는 태그
  - 해당 링크를 누르면 어떤 component가 보여지게 될 지에 대한 Maping 정보를 제공해야함.
- `<router-view>`
  - 화면 이동의 결과가 보여지는 영역을 명시하는 태그

### VueRouter
- `<router-link>`와 components의 mapping 정보를 저장하는 객체

### 중첩 라우터
- router-view 내부에 또 다른 router-view가 존재
- 매핑 링크를 더 하위단계로 구성하여 세부적으로 나누어 사용

### 동적 라우터(정리 필요)

## 라우터; CLI Project
### 호출 흐름도
- Components
  - HellowWorld.vue
  - 화면을 구성하는 가장 작은 단위
- Views
  - router-view에 표시될 컴포넌트
  - components에 존재하는 vue를 가지고 화면을 구성함
  - HomeView.vue => import HellowWorld.vue
  - AboutView.vue
  - 조각(components) 모음으로 구성하는 단위
- App.vue
  - router-link
  - router-view
- router
  - index.js
    - router 정보
    - Views의 components를 사용하기위해 모아놓은 곳
- main.js
  - vue 객체 생성
  - router 등록
- index.html
  - main.js에서 생성한 vue 출력

### 실습 순서
1. routerTest1
2. nestedRouter
3. namedView
4. dynamicRouter
    - created()
    - this.fetchData()
    - this.users = userData;
5. routertest; CLI project