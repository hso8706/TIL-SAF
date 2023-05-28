# 23.05.18

### JWT 로그인 인증

- 흐름도
  - 클라이언트가 백엔드 서버에 로그인 인증 요청(username, password 전송)
  - Security filtering(JwtAuthenticationFilter)
  - AuthenticationManager에게 인증 처리 위임
  - AuthenticationManager가 UserDetailsService에게 UserDetails 조회를 위임
  - UserDetailsService가 전달받은 username, password를 기반으로 userdetails를 조회한 후 결과를 AuthenticationManager에게 전달
  - AuthenticationManager가 클라이언트로부터 전달받은 인증 정보(username, password)와 userDetails를 비교하여 인증 처리
  - JWT 생성 후 클라이언트에 응답 처리
- 인증 컴포넌트
  - MemberDetailsService
    - UserDetails 조회를 담당하는 서비스 객체
    - .loadUserByUsername() 메소드가 핵심

### JWT 자격 증명 및 검증

- 흐름도
  - 클라이언트에서 자격 증명이 필요한 resource(uri)에 대한 request 전송임을 확인
  - 해당 상황에서 클라이언트는 JWT를 request header에 저장하여 보냄
  - 백엔드 서버에서는 request header의 JWT를 확인
    - OncePerRequestFilter를 상속한 필터를 사용
      - 1 request 당 1번 실행
    - doFilterInternal 구현
      - OncePerRequestFilter를 상속하면 doFilter 대신 doFilterInternal를 구현하여 사용

### 인증 타입

- Basic : Base64로 인코딩
- Bearer : JWT 혹은 OAuth에 대한 토큰
- ...

### OAuth2 - google client
- 승인된 리디렉션 URI
  - http://localhost:8080/login/oauth2/code/google

### OAuth2 - JWT 구현

- flow chart

1. Google 로그인 링크 버튼 클릭
2. 지정된 google 로그인 URI 로 request 전송
   - 해당 URI는 OAuth2LoginAuthenticationFilter에서 처리
3. google 로그인 화면을 요청하는 URI로 리다이렉트
4. google 로그인 화면 오픈
5. Resouce Owner의 google 로그인 작업 수행
6. 로그인 성공 시, Authorization Code를 제공 받음(Authorization Server => Backend Server)
7. Access Token 요청 및 응답()
   - 해당 Access Token은 Resouce Owner의 resource를 Google Resource Server에 요청하는 용도
8. Backend 애플리케이션이 Resource Server에 User Info를 요청 및 응답
9. User Info를 기반으로 Backend 애플리케이션이 JWT 생성 및 Frontend server로 전달

- Components

1. JwtTokenizer
   - Jwt에 대한 메서드를 모아놓은 객체
     - Secret Key Encoding(Base64)
     - Secret Key For JWT Encoding(hmacSha)
     - AccessToken 생성
     - RefreshToken 생성
     - VerifySignature; 단순 검증
     - GetClaims; 검증 후 Claims 추출(사용자 정보)
     - TokenExpiration : 토큰 만료기간 생성
2. .yml 설정
   - OAuth2
     - OAuth2 client id, secret 추가 : google
     - 활용 scope 설정 : email, profile
   - JWT
     - 비밀키, access 만료, refresh 만료 설정
3. JwtVerificationFilter 추가
   - OAuth2 인증에 성공한 상태에 사용될 filter
   - OAuth2 인증에 성공한 후, front에서 request를 전송할 때마다 Authorization header에 존재하는 Access Token에 대한 검증 수행하는 Filter
4. OAuth2MemberSuccessHandler
   - OAuth2 인증에 성공하면 호출되는 핸들러
   - OAuth2 인증에 성공 후 JWT를 생성하고, Front로 JWT를 전송할 redirect 로직 구현
5. SecurityConfigiguration 설정
   - HttpSecurity.oauth2Login 필터 설정에서 .successHandler()를 추가하여 OAuth2 인증에 성공했을때의 작업을 지정
   - 성공 시 실행되는 작업: OAuth2MemberSuccessHandler 객체를 생성하며 DI 주입
   - OAuth2LoginAuthenticationFilter 뒤에 (3)JwtVerificationFilter를 추가하여 Access Token을 검색하는 필터를 추가하는 설정 지정
