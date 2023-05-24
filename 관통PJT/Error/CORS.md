### 대분류

- CORS Error

### 환경

- front
  ```json
    "axios": "^1.4.0",
    "bootstrap": "^4.6.1",
    "bootstrap-vue": "^2.23.1",
    "core-js": "^3.8.3",
    "vue": "^2.7.14",
    "vue-router": "^3.5.1",
    "vuex": "^3.6.2"
  ```
- back
  ```
    java: 17
    spring boot: 3.0.6
    spring security 사용
  ```

### 문제1.

- msg
  ```
  Access to XMLHttpRequest at 'http://localhost:8080/members' from origin 'http://localhost:3000' has been blocked by CORS policy: Response to preflight request doesn't pass access control check: No 'Access-Control-Allow-Origin' header is present on the requested resource.
  ```
- 원인
  - CORS 정책으로 인해 통신이 막힌 상황이 원인
- 해결
  - spring security 를 이용하여 새로운 `CorsConfigurationSource` 빈 객체를 작성함
  - CorsConfiguration.setAllowedOrigins("\*") 를 명시하여 origin 문제를 해결
    - security 3.x 로 변경되면 해당 메서드 대신 `setAllowedOriginPatterns`을 사용
  - 추가로 methods와 request header의 허용을 열어줌
    - 각각 CorsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PATCH", "DELETE")), CorsConfiguration.setAllowedHeaders(Arrays.asList("\*"))이다.
  - 위 작업 후 정상적으로 클라이언트에서 백엔드 요청과 응답이 확인되었다.

### 문제2.

- 문제
  - back server에서 로그인 시 JWT 정보를 response.header에 키, 밸류 값을 새로 설정하여 응답하였으나 client에서는 올바른 header 정보를 받을 수 없었음
  - 하지만 postman으로 확인한 결과에서는 문제없이 back server에서 의도한대로 수정된 header정보를 받음
  - 따라서 cors를 의심함
- 해결
  - 이전에 CORS 문제를 해결하기 위해 추가했던 `CorsConfigurationSource`에 추가적인 메서드가 필요했음
  - 필요한 메서드는 CorsConfiguration.setExposedHeaders(Arrays.asList("\*"));으로 이는 Client로 전달하는 Response의 Header의 정보를 어느정도 오픈하는지에 대한 설정이다.
