## 코드
```
@NoArgsConstructor(access = AccessLevel.PROTECTED)
```

## 설명
- 해당 lombok 생성자의 접근 제어자 설정을 하는 옵션
  1. AccessLevel.PUBLIC: 이 옵션을 사용하면 생성자가 public으로 생성됩니다. 즉, 어떤 클래스에서든 해당 생성자를 호출할 수 있습니다. 이것은 가장 열린 범위로 생성자를 생성하는 것입니다.
  2. AccessLevel.PROTECTED: 생성자가 protected로 생성됩니다. 이 경우 해당 클래스와 해당 클래스를 상속받은 서브클래스에서만 생성자를 호출할 수 있습니다. 외부 클래스에서는 직접 생성자를 호출할 수 없습니다.
  3. AccessLevel.PACKAGE: 생성자가 패키지(private 패키지) 범위로 생성됩니다. 같은 패키지 내의 클래스에서만 생성자를 호출할 수 있으며, 다른 패키지에서는 직접 호출할 수 없습니다.
  4. AccessLevel.PRIVATE: 생성자가 private으로 생성됩니다. 이 경우 해당 클래스 내에서만 생성자를 호출할 수 있으며, 외부 클래스에서는 직접 호출할 수 없습니다. 이 설정은 보통 싱글톤 패턴과 같은 경우에 사용됩니다.