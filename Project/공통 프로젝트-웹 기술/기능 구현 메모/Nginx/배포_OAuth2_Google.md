### google console
- 승인된 리디렉션 URI
  - `https://{도메인}/oauth2/code/google`

### https
- Google OAuth2의 로그인을 위해서는 승인된 리디렉션 URL을 google api console에 작성해야함.
- 프로덕션 단계에서는 http는 사용 불가하고 https를 사용해야함
- 프로덕션 단계이어야 모든 사용자가 접근할 수 있음

### ssl 인증 받기
- https를 사용하기 위해서 ssl 인증받는 과정이 필요.
- `Nginx.md` 설명 참고

### Error1. Mismatch
- 이미지
  ![image](https://github.com/hso8706/Useful/assets/103169947/cde46adb-9189-48d0-9f39-d32337b2a945)
- 에러 메세지
  ```
  오류 400: redirect_uri_mismatch

  앱이 Google의 OAuth 2.0 정책을 준수하지 않기 때문에 앱에 로그인할 수 없습니다.

  앱 개발자라면 Google Cloud Console에서 리디렉션 URI를 등록하세요.
  요청 세부정보: redirect_uri=http://www.tcha.site/login/oauth2/code/google
  ```
- 에러 상황
  redirect

### Error2. 


### 참고 링크
- 참고 링크
  - https://www.sunny-son.space/AWS/HTTPS%20%EC%84%A4%EC%A0%95%ED%95%98%EA%B8%B0/
  - https://yeni-days.tistory.com/9

- 명령어
  - http://www.wontree.net/board/340b960b-af5b-11ea-8bd5-0a68fbfeb10e/view/179