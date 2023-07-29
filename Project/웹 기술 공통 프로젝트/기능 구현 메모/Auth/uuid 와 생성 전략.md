### UUID
- UUID: Universally Unique Identifier
- 128비트, 고유한 식별자
- Version 1(UUIDv1), Version 4(UUIDv4)이 존재
- `xxxxxxxx-xxxx-Mxxx-Nxxx-xxxxxxxxxxxx`와 같이 표현

### JPA에서 UUID 사용하기 1
```java
@Id
@GeneratedValue(strategy = GenerationType.UUID)
private UUID id;
```
- JPA 표준에서 제공하는 `GenerationType` 열거형 상수를 사용하여 UUID를 생성하는 방식
- 데이터베이스 종류에 따라 다르게 동작

### JPA에서 UUID 사용하기 2
```java
@Id
@GeneratedValue(generator = "uuid2")
@GenericGenerator(name = "uuid2", strategy = "uuid2")
@Column(columnDefinition = "CHAR(32)")
private UUID id;
```
- @GenericGenerator 어노테이션을 사용하여 사용자 정의된 "uuid2"라는 이름의 키 생성기를 사용하는 방법
- `uuid2`전략은 Hibernate라는 JPA 구현체에서 제공하는 특정 전략
  - Version 4(랜덤 생성)을 사용하며, 하이픈을 포함하지 않는 32자의 문자열 형태로 UUID를 생성
- UUID 전략을 사용하면 JPA는 기본적으로 36자의 CHAR형과 매핑함. 32자의 문자열로 매핑