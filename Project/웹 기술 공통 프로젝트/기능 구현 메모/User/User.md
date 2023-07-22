# 현재 구현 상황

## User

### default URL
- `/users`

### post
    - POST Method 사용
    - 비어있는 request body 필요
    - uuid를 통해 난수를 생성하여 PK(id)로 지정
    - 회원 상태, 회원 권한에 default 값 존재
    - createdAt, modifiedAt 생성
    - 201 create code

### get
    - GET Method 사용
    - pk를 통해 1개 조회, 즉 상세 조회 가능
    - 200 ok code

### delete
    - DELETE Method 사용
    - db내에서 삭제되는 것이 아닌 회원 상태의 변경( => USER_QUIT )
    - modifiedAt 변경
    - 204 no content code

### Exception
    - userService.findVerifiedUser() 메서드를 사용함으로써 get, delete handler는 user-id가 잘못되었거나, 없으면 예외 발생
    - 404, User not found