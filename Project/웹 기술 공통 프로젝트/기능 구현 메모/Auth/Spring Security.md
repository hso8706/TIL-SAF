### Spring Security
- Spring MVC 기반 애플리케이션의 인증(Authentication)과 인가(Authorization or 권한 부여) 기능을 지원하는 보안 프레임워크
- Spring MVC 기반 애플리케이션에 보안을 적용하는 사실상 표준으로 사용됨

### Spring Security에서 사용되는 용어
-Pricipal(주체)
    - 애플리케이션에서 작업을 수행하는 개체(사용자, 디바이스, 시스템 등)
    - 일반적으로 인증 프로세스가 성공적으로 수행된 사용자의 계정 정보를 의미함.
-Authentication(인증)
    - 애플리케이션 사용자가 본인이 본인임을 증명하는 절차
    - 사용자를 식별하기 위한 정보를 Credential(신원 증명 정보)라고 함.
-Authorization(인가, 권한 부여)
    - 애플리케이션의 특정 리소스에 접근할 수 있게 허가하는 과정
    - Authentication이 정상적으로 수행된 사용자에게 하나 이상의 권한(authority)을 부여함
    - 반드시 Authentication(인증)과정이 선행되어야 하고, 권한은 일반적으로 역할 형태로 부여됨.
-Access Control(접근 제어)
    - 사용자가 애플리케이션 리소스에 접근하는 행위를 제어하는 것

### Spring Security 로그인 흐름도_간략
![image](https://github.com/hso8706/TIL-SAF/assets/103169947/170b8c18-7925-4d77-a3ff-94f081a22d68)

  - 인증 관리자
    1. 로그인 요청을 처리하는 필터(UsernamePasswordAuthenticationFilter)
    2. Username(로그인 ID)와 Password를 받고, 이를 바탕으로 아직 인증 상태 정보가 없는 Authentication을 만듬.
    3. 내부 로직을 거쳐 인증 상태 정보가 저장된 Authentication을 만듬.
    4. SecurityContext에 인증된 Authentication을 저장함.

  - 접근 결정 관리자
    1. 리소스 접근 권한을 부여하는 필터(AuthorizationFilter)
    2. SecurityContext에서 인증처리된 Autentication을 가져옴.
    3. URL 기반으로 요청을 매칭처리하는 로직으로 권한을 부여함.

### Spring Security 로그인 흐름도_세부
![image](https://github.com/hso8706/TIL-SAF/assets/103169947/8f6d4dd5-e6dd-4452-8074-95861bfa6527)