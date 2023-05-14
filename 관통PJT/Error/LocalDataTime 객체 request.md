### 에러 메세지
```
2023-05-14T18:15:55.714+09:00 ERROR 12656 --- [nio-8080-exec-6] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed: java.time.format.DateTimeParseException: Text '2023-05-14' could not be parsed at index 10] with root cause
```

### 해결1.
- LocalDateTime 형식으로 값을 보내지 않아서 문제 발생
- `YYYY-MM-DDTHH:MM:SS`식으로 문제해결
  - YYYY : 년
  - MM : 월
  - DD : 일
  - T : 띄어쓰기 대신 사용
  - HH : 시
  - MM : 분
  - SS : 초
- 예시 : 2023-01-18T11:22:33 

### 해결2.
- 애너테이션 사용
  - @JsonFormat : server -> client
  - @DateTimeFormat : client -> server
- 추가 자료 공부 필요