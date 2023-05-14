### Error msg
```
org.springframework.web.HttpMediaTypeNotAcceptableException: No acceptable representation
```

### 원인
- 반환하는 Dto 객체에 Getter 가 없어서 발생하는 문제
- Getter가 없으면 클라이언트가 요청한 Type으로 응답을 반환할 수 없다고함.
- 자세히는 추가 공부 필요