### msg

```
java.lang.IllegalArgumentException: When allowCredentials is true, allowedOrigins cannot contain the special value "*" since that cannot be set on the "Access-Control-Allow-Origin" response header. To allow credentials to a set of origins, list them explicitly or consider using "allowedOriginPatterns" instead.
```

### 해결

- Spring 3.x 에서는 `CorsConfiguration.setAllowCredentials(true);`와 `CorsConfiguration.setAllowedOrigins(Arrays.asList("*"));`를 동시에 사용할 수 없도록 업데이트 되었다고 한다.
- `CorsConfiguration.setAllowedOrigins()` 대신 `CorsConfiguration.setAllowedOriginPatterns()`를 사용하면 된다
