import java.util.List;

public interface CustomerService {

	List<Customer> selectAll();//all data
	Customer findByNum(int num);//num에 해당하는 레코드 1건
	List<Customer> findByName(String name);//like 검색
	List<Customer> findByAddress(String address);//주소 그냥 검색
	
	int add(Customer p); // 새로운 고객 추가
	int delete(int num); // 고객 삭제(회원 탈퇴)
	int update(int num, String address);//번호기준으로 주소 변경	
}
/*
CustomerService interface
: 제공되는 기능을 분류하여 명시해놓은 인터페이스
: 실질적인 기능을 구현하진 않음
: 해당 인터페이스를 확인함으로써, 클라이언트는 해당 앱에 어떤 기능이 존재하고 어떻게 사용할 지 판단 가능

1. selectAll()
: 데이터베이스(customer table)내에 존재하는 모든 records 를 호출 및 반환

2. findByNum(int num)
: num(int, pk, nn)을 인자로 제공
: num 에 해당하는 record 를 호출 및 반환

3. findByName(String name)
: name(str, nn)을 인자로 제공
: name 에 해당하는 record 를 호출 및 반환
: name 의 전체가 아닌 일부를 입력하더라도 호출할 수 있도록 기능 설정

4. findByAddress(String address)
: address(str, nn)을 인자로 제공
: address 에 해당하는 record 를 호출 및 반환
: table 내의 address 는 한 단어의 도시명으로 저장되어 있음.

5. add(Customer p)
: 고객의 각각의 정보(num, name, address)를 묶어주는 Customer 타입으로 고객의 정보를 저장

6. delete(int num)
: num(int, pk, nn)을 인자로 제공
: num 에 해당하는 고객의 정보를 DB table 에서 삭제

7. update(int num, String address)
: num(int, pk, nn)과 address(str, nn)를 인자로 제공
: num 을 기준으로 data 를 조회하고 해당 data 의 address 를 수정함.
: 주의할 것은 인자로 제공되는 num 이 해당 테이블에 없을 경우를 처리해야함.
	- 처리 방법 1: 해당 num 과 address 를 table 에 저장
	- 처리 방법 2: 에러 메세지 출력
 */