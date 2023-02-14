### Comparable & Comparator (interface)
- 목적
  - 객체를 비교해서 정렬할 때 사용되는 interface
  - 추상 메서드 => 정렬 기준을 나타내는 메서드
- Comparable interface
  - 객체를 정의할 때 `implements`로 구현을 표시
  - 추상 메서드 : `compareTo()`
  - .sort() 메서드의 기준을 정해주는 것
  - sort()메서드
    - Collections, Arrays class등의 메서드
    - Comparable 인터페이스를 구현한, 그리고 Comparable 인터페이스의 제네릭 인자로 제공되는 클래스형에 대한 정렬 메서드
- Comparator interface
  - 객체 내부에 정의된 정렬 기준 이외의 기준으로 정렬할 때 사용
  - Comparable 에다가 추가로 더 사용하는 느낌(?)
  
- 참고
  - 0210_현장강의.md
  - compare_01_230210 package 참고
