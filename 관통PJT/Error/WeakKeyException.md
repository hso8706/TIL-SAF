### Error msg

```
io.jsonwebtoken.security.WeakKeyException: The specified key byte array is 88 bits which is not secure enough for any JWT HMAC-SHA algorithm.  The JWT JWA Specification (RFC 7518, Section 3.2) states that keys used with HMAC-SHA algorithms MUST have a size >= 256 bits (the key size must be greater than or equal to the hash output size).  Consider using the io.jsonwebtoken.security.Keys#secretKeyFor(SignatureAlgorithm) method to create a key guaranteed to be secure enough for your preferred HMAC-SHA algorithm.  See https://tools.ietf.org/html/rfc7518#section-3.2 for more information.
```

### 원인

- JWT HMAC-SHA algorithm을 사용할 때 secret key가 256 bit를 넘지 않아서 발생한 에러

### 해결

- secret key를 256 bit가 넘는 String 으로 변경하여 해결
