### 에러메세지
    io.jsonwebtoken.security.WeakKeyException: The specified key byte array is 80 bits which is not secure enough for any JWT HMAC-SHA algorithm.  The JWT JWA Specification (RFC 7518, Section 3.2) states that keys used with HMAC-SHA algorithms MUST have a size >= 256 bits (the key size must be greater than or equal to the hash output size).  Consider using the io.jsonwebtoken.security.Keys#secretKeyFor(SignatureAlgorithm) method to create a key guaranteed to be secure enough for your preferred HMAC-SHA algorithm.  See https://tools.ietf.org/html/rfc7518#section-3.2 for more information.

### 에러 상황
    - Google OAuth2 로그인 진행 후 에러 발생

### 원인 분석
    - 이전에 겪어본 에러
    - JWT 암호화 알고리즘을 사용할 때 secret key가 256bit를 넘겨야되는데 256bit 보다 작기 때문에 발생하는 오류

### 해결 과정
    - build.gradle 내 lombok과 mapstruct의 순서 변경
      - 실패
    - lombok-mapstruct-binding 0.2.0 라이브러리 추가
      - 실패
    - 우선은 추가 작업 후 이후 다른 로컬에서도 이러한 문제가 발생하거나, 다른 작업에서도 같은 문제가 발생하면 추가로 알아볼 예정

### 해결
    - 진짜진짜 어이없네...
    - dto 필드명과 entity 필드명을 완전히 똑같이 맞추니까 해결되었음. 실수로인한 오타가 존재했다.
    - 원래 필드명이 동일해야하는지 이유를 모름. mapstruct의 동작 원리를 다시 파악하자 