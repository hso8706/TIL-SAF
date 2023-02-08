## Collections.sort()
- 인자 : List<T>
- 반환값 : void -> 인자를 그냥 변경
    
```java
@SuppressWarnings("unchecked")
public static <T extends Comparable<? super T>> void sort(List<T> list) {
    list.sort(null);
}
```