- `limit`
```
limit 5; // 5개만 출력
limit 4, 10; // 5번째 데이터부터 10개 출력, 파라미터 idx는 0부터 시작
```

- `reverse(args)`
  - args를 역순으로 출력한다.

- DDL
  - 기본 테이블 생성
  ```
  create table table_name (
      id int,
      ...
      ...;
  )
  ```

  - 테이블 컬럼 추가(alter add)
  ```
  alter table table_name add column_name type;
  ```

  - 테이블 컬럼 변경(alter change)
    - alter table table_name change 현컬럼명 이후컬럼명 수정옵션;
  - 테이블 컬럼 삭제(alter drop)
    - alter table table_name column clomun_nae;