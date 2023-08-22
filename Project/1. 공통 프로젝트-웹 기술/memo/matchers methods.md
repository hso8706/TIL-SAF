### hasRole, hasAnyRole, hasAuthority, hasAnyAuthority
- hasRole, hasAnyRole
  - "ROLE_"라는 접두사가 있다는 가정하에 인자로 주어진 권한(String)을 검증하는 메소드
- hasAuthority, hasAnyAuthority
  - 기본 접두사가 없고, 오로지 인자로 주어진 권한(String)과 정확히 일치하는지 검증하는 메소드

### 결론
- "ROLE_"을 기본으로 접두사로 사용한다면 hasRole, hasAnyRole을 사용하는게 편하다.