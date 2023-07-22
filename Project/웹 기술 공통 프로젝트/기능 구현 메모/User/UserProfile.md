# 현재 구현 상황

## UserProfile

### default URL
- `/userProfiles/{user-id}`
- 기본적으로 {user-id}가 있어야 사용 가능
- 모든 api는 {user-id}로만 사용 가능함

### post
    - POST Method 사용
    - request body 필요
    - uuid를 통해 난수를 생성하여 PK(id)로 지정
    - default 값 존재(null)
    - createdAt, modifiedAt 생성
    - 201 create code

### patch
    - PATCH Method 사용
    - 수정을 원하는 필드만 입력해도 수정 가능
    - modifiedAt 변경
    - 200 ok code

### get
    - GET Method 사용
    - pk를 통해 1개 조회, 즉 상세 조회 가능
    - 200 ok code

### delete
    - DELETE Method 사용
    - db내에서 삭제되는 것이 아닌 모든 필드를 null로 변경( => 특정 필드 혹은 이미지만 null이 되도록 변경할 예정 )
    - modifiedAt 변경
    - 204 no content code

### Exception
    - userService.findVerifiedUser() 메서드를 사용함으로써 모든 handler는 user-id가 잘못되었거나, 없으면 예외 발생
    - 404, User not found