# 23.05.04
### MVVM
- Vue에서 사용하는 디자인 패턴
- MVVM : Model View VM
- VM: View(화면) 와 Model(data logic) 중간에 존재하는 Vue 객체

### Vuew Instance Life Cycle
- new Vue()
- 라이프 사이클 관련 메서드
  - created
    - el option 유무 확인 혹은 template 옵션 유무 확인
  - mounted
  - updated
  - destroyed

### Vue.js에서 사용되는 표현식
- 모든 데이터 바인딩(`{{}}`) 내에서 JavaScript 표현식의 모든 기능을 지원함
- 표현식(expression)이 아닌 구문(statement)는 사용할 수 없다.
  - 표현식 : return 값이 존재
  - 구문 : retrun 값이 없는 문장

### template - Directives