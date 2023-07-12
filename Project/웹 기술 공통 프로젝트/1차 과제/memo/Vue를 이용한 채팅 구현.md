### Vue3와 Vue2의 차이점
- Composition API
- 템플릿 생성 방식의 변화
- Lifecycle hook 호출의 변화
- Computed 속성 사용방법의 변화
- Data, method 작성 방식의 변화

### 채팅 로직 고려사항
- S1 Data
  - UID: 작성자
  - Contents: 내용
  - MCTime (Message Creativce Time): 작성 시간
  - ProfilePhotoURL
  - 읽기 여부 
- 위와 같은 데이터(S1, ..., Sn)를 array 형식으로 묶음