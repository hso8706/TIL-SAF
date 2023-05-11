# 23.05.11
### axios 라이브러리 추가
- cdn
  ```html
	<script src="https://unpkg.com/axios/dist/dxios.min.js"></script>
  ```
- cli
  ```
  npm i axios
  ```

### 흐름도
- 이벤트
- 이벤트 메소드
- axios처리
- 화면 재구성 메소드

### axios 사용
- axios
- .get / .post / .put / .delete
  - url 인자 제공
  - pathVariable 인자 제공
  - RequestBody 인자 제공
- .then
  - 응답을 받고 처리할 작업 작성

### 속성 호출
- `$` 키워드
- this.$router.~~~
- 예시
  ```javascript
  var vm = new Vue({
    el:"#app",
    data(){
      return{
        num:123
      }
    }
  })

  <!-- 
  - vm의 num 호출하기
  => vm.num
  => vm.$data.num
  -->
  ```
- 온갖 곳에서 $router를 쓸 수 있는 이유
  - 전역으로 Vue.use(VueRouter)를 사용했기 때문