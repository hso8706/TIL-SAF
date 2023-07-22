### 에러메세지
    - 없음

### 에러 상황
    - response body에 createAt의 값이 null로 나옴

### 원인 분석
    - db에는 정상적으로 createAt이 저장되고 response body에만 문제 발생
    - mapper impl을 살펴보니 auditable로 생성하는 createAt에 대한 mapstruct의 매핑이 되지 않음

### 해결 방법
    - build.gradle 내 lombok과 mapstruct의 순서 변경
      - 실패
    - lombok-mapstruct-binding 0.2.0 라이브러리 추가
      - 실패
    - 우선은 추가 작업 후 이후 다른 로컬에서도 이러한 문제가 발생하거나, 다른 작업에서도 같은 문제가 발생하면 추가로 알아볼 예정