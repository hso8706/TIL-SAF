import java.util.List;

public class CustomerTest {

	public static void main(String[] args) {
		CustomerService s = new CustomerDAO();
		//1. 모든 고객 정보를 받아서 화면에 출력
		List<Customer> test_1 = s.selectAll();
		for(int i = 0; i < test_1.size(); i++){
			System.out.printf("num: %s, name: %s, address: %s\n", test_1.get(i).getNum(), test_1.get(i).getName(), test_1.get(i).getAddress());
		}
		//2. 고객 번호 기준 검색 후 결과 출력
		int num = 111;
		Customer test_2  = s.findByNum(num);
		System.out.printf("num: %s, name: %s, address: %s\n", test_2.getNum(), test_2.getName(), test_2.getAddress());
		//3. 고객 이름 기준으로 검색 후 결과 출력(이름의 일부가 포함된 경우도 포함. like 검색)
		String name = "da";
		List<Customer> test_3 = s.findByName(name);
		for(int i = 0; i < test_3.size(); i++){
			System.out.printf("num: %s, name: %s, address: %s\n", test_3.get(i).getNum(), test_3.get(i).getName(), test_3.get(i).getAddress());
		}
		//4. 고객 주소 기준으로 검색 후 결과 출력
		String address = "seoul";
		List<Customer> test_4 = s.findByAddress(address);
		for(int i = 0; i < test_4.size(); i++){
			System.out.printf("num: %s, name: %s, address: %s\n", test_4.get(i).getNum(), test_4.get(i).getName(), test_4.get(i).getAddress());
		}
		//5. 새고객 추가 후 확인
		Customer insert = new Customer("1011", "forTest", "seoul");
		System.out.println(s.add(insert));
		//6. 고객 삭제 후 확인
		int testNumForDelete = 1011;
		System.out.println(s.delete(testNumForDelete));
		//7. 고객 정보 수정 후 확인
		s.add(insert);
		int testNumForUpdate = 1011;
		String testAddressForUpdate = "forTest";
		s.update(testNumForUpdate, testAddressForUpdate);
		Customer testUpdate  = s.findByNum(testNumForUpdate);
		System.out.printf("num: %s, name: %s, address: %s\n", testUpdate.getNum(), testUpdate.getName(), testUpdate.getAddress());
		s.delete(testNumForUpdate);
	}

}
