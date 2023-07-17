### Auditing
- 엔티티의 생성 및 수정에 대한 자동 기록
- 데이터의 변경 이력을 추적하고 관리하기 위한 기능 제공

### Auditing 구현 코드
```java
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable {

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "last_modified_at")
    private LocalDateTime modifiedAt;

}
```

### @Getter
- lombok 어노테이션
- 선택 사항, createAt, modifiedAt을 호출할 경우를 대비하여 작성

### @MappedSuperclass
- Jpa 어노테이션
- 해당 클래스는 엔티티 클래스가 아닌 부모 클래스임을 명시
- 다른 엔티티 클래스에서 해당 클래스를 상속받을 수 있다.

### @EntityListeners(AuditingEntityListener.class)
- JPA 어노테이션(Spring Data JPA)
- 해당 클래스를 엔티티 클래스 리스너로 등록
- 엔티티의 생성 및 수정 시점을 처리하는 역할

### @CreatedDate
- Spring Data JPA 어노테이션(Auditing 어노테이션)
- 엔티티가 생성될 때 해당 필드에 자동으로 현재 날짜 및 시간을 설정

### @LastModifiedDate
- Spring Data JPA 어노테이션(Auditing 어노테이션)
- 엔티티가 수정될 때 해당 필드에 자동으로 최종 수정일자를 갱신

### JPA; 데이터베이스 컬럼명 전략
- 카멜 케이스 => 스네이크 케이스

### LocalDateTime 객체
- Java 8부터 제공되는 날짜와 시간을 표현하는 클래스
- 년, 월, 일, 시, 분, 초, 밀리초 등의 정보를 저장
- 날짜와 시간을 표현하는 다양한 메소드를 제공
- 불변(immutable) 클래스로 설계되어 있어 스레드 안전하게 사용가능