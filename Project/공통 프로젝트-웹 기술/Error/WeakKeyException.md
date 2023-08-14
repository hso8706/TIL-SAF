### 에러메세지
    io.jsonwebtoken.security.WeakKeyException: The specified key byte array is 80 bits which is not secure enough for any JWT HMAC-SHA algorithm.  The JWT JWA Specification (RFC 7518, Section 3.2) states that keys used with HMAC-SHA algorithms MUST have a size >= 256 bits (the key size must be greater than or equal to the hash output size).  Consider using the io.jsonwebtoken.security.Keys#secretKeyFor(SignatureAlgorithm) method to create a key guaranteed to be secure enough for your preferred HMAC-SHA algorithm.  See https://tools.ietf.org/html/rfc7518#section-3.2 for more information.

### 에러 상황
- Google OAuth2 로그인 진행 후 에러 발생

### 원인 분석
- 이전에 겪어본 에러
- JWT 암호화 알고리즘을 사용할 때 secret key가 256bit를 넘겨야되는데 256bit 보다 작기 때문에 발생하는 오류

### 해결
- secret key의 길이를 마구 늘려줌