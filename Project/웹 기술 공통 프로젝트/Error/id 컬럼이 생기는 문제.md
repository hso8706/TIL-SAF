### Error message
```
Hibernate: 
    select
        u1_0.id,
        u1_0.created_at,
        u1_0.email,
        u1_0.last_modified_at,
        r1_0.user_id,
        r1_0.roles,
        u1_0.status,
        u2_0.user_profile_id,
        u2_0.created_at,
        u2_0.last_modified_at,
        u2_0.name,
        u2_0.profile_image 
    from
        users u1_0 
    left join
        user_roles r1_0 
            on u1_0.id=r1_0.user_id 
    left join
        user_profile u2_0 
            on u1_0.id=u2_0.user_id 
    where
        u1_0.id=?
Hibernate: 
    insert 
    into
        user_profile
        (created_at, last_modified_at, name, profile_image, user_id) 
    values
        (?, ?, ?, ?, ?)
2023-08-03T07:53:01.067Z  WARN 197604 --- [nio-8080-exec-1] o.h.engine.jdbc.spi.SqlExceptionHelper   : SQL Error: 1364, SQLState: HY0002023-08-03T07:53:01.067Z ERROR 197604 --- [nio-8080-exec-1] o.h.engine.jdbc.spi.SqlExceptionHelper   : (conn=9276) Field 'id' doesn't have a default value
2023-08-03T07:53:01.069Z ERROR 197604 --- [nio-8080-exec-1] c.t.u.e.c.GlobalExceptionAdvice          : # handle Exception

org.springframework.dao.DataAccessResourceFailureException: could not execute statement
        at org.springframework.orm.jpa.vendor.HibernateJpaDialect.convertHibernateAccessException(HibernateJpaDialect.java:253) ~[spring-orm-6.0.10.jar!/:6.0.10]
```

### 에러 상황
- DB를 초기화하면서 처음 서버를 실행시키는 경우 정상적으로 진행됨
- 처음엔 user_profile_id 만 정상적으로 존재하지만, 이후에 프론트에서 테스트를 하다보면 id라는 컬럼이 새로 생김
- id 컬럼이 생기면서 id를 찾을 수 없다는 에러와 함께 문제가 발생
- userProfile에서 계속 에러가 발생