import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//DAO : DB에 접근하여 CRUD 작업을 하는 객체
public class CustomerDAO implements CustomerService{
	
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/scottdb?serverTimezone=UTC&characterEncoding=UTF-8";
	String user = "scott";
	String password = "tigertiger";
//	String query = "";

	//1. driver loading method
	public CustomerDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//2. connection create method
	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	@Override
	public List<Customer> selectAll() {
		Connection con = getConnection();
		List<Customer> customerListForResult = new ArrayList<>();
		try {
			Statement stat = con.createStatement(); // create statement
			String query = "select num, name, address from customer";
			ResultSet rs = stat.executeQuery(query);

			while(rs.next()) {
				String num = rs.getString(1);
				String name = rs.getString(2);
				String address = rs.getString(3);
				Customer temp = new Customer(num, name, address);
				customerListForResult.add(temp);
			}
			rs.close();
			stat.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerListForResult;
	}

	//TODO 인자로 제공된 num이 DB에 없을 경우 처리
	@Override
	public Customer findByNum(int num) {
		Connection con = getConnection();
		Customer recordForResult = new Customer();
		Statement stat = null; // create statement
		try {
			stat = con.createStatement();
			String query = "select num, name, address from customer where num = " + Integer.toString(num);
			ResultSet rs = stat.executeQuery(query);
			while(rs.next()) {
				recordForResult.setNum(rs.getString(1));
				recordForResult.setName(rs.getString(2));
				recordForResult.setAddress(rs.getString(3));
			}
			rs.close();
			stat.close();
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return recordForResult;
	}

	@Override
	public List<Customer> findByName(String name) {
		Connection con = getConnection();
		List<Customer> customerListForResult = new ArrayList<>();
		Statement stat = null; // create statement
		try {
			stat = con.createStatement();
			String query = "select num, name, address from customer where name like " + "'%" + name + "%'";
			ResultSet rs = stat.executeQuery(query);
			while(rs.next()) {
				Customer recordForResult = new Customer();
				recordForResult.setNum(rs.getString(1));
				recordForResult.setName(rs.getString(2));
				recordForResult.setAddress(rs.getString(3));
				customerListForResult.add(recordForResult);
			}
			rs.close();
			stat.close();
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return customerListForResult;
	}

	@Override
	public List<Customer> findByAddress(String address) {
		Connection con = getConnection();
		List<Customer> customerListForResult = new ArrayList<>();
		Statement stat = null; // create statement
		try {
			stat = con.createStatement();
			String query = "select num, name, address from customer where address = " + "'" + address + "'";
			ResultSet rs = stat.executeQuery(query);
			while(rs.next()) {
				Customer recordForResult = new Customer();
				recordForResult.setNum(rs.getString(1));
				recordForResult.setName(rs.getString(2));
				recordForResult.setAddress(rs.getString(3));
				customerListForResult.add(recordForResult);
			}
			rs.close();
			stat.close();
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return customerListForResult;
	}

	@Override
	public int add(Customer p) {
		Connection con = getConnection();
		PreparedStatement pstat = null; // create statement for insert
		int result = -1;
//		Statement stat = null; // create statement for return
//		Customer recordForResult = new Customer();

		try {
			String queryForInsert = "insert into customer values (?, ?, ?);";
//			String queryForSelect = "select num, name, address from customer where where num = " + p.getNum() ;

			pstat = con.prepareStatement(queryForInsert);
			pstat.setInt(1, Integer.valueOf(p.getNum()));
			pstat.setString(2, p.getName());
			pstat.setString(3, p.getAddress());
			result = pstat.executeUpdate();

//			stat = con.createStatement();
//			ResultSet rs = stat.executeQuery(queryForSelect);
//			while(rs.next()) {
//				recordForResult.setNum(rs.getString(1));
//				recordForResult.setName(rs.getString(2));
//				recordForResult.setAddress(rs.getString(3));
//			}

//			rs.close();
			pstat.close();
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return result;
	}

	@Override
	public int delete(int num) {
		Connection con = getConnection();
		PreparedStatement pstat = null; // create statement for insert
		int result = -1;

		try {
			String queryForInsert = "delete from customer where num = ?";


			pstat = con.prepareStatement(queryForInsert);
			pstat.setInt(1, num);
			result = pstat.executeUpdate();

			pstat.close();
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return result;
	}

	@Override
	public int update(int num, String address) {
		Connection con = getConnection();
		PreparedStatement pstat = null; // create statement for insert
		int result = -1;

		try {
			String queryForInsert = "update customer set address = ? where num = ?" ;


			pstat = con.prepareStatement(queryForInsert);
			pstat.setString(1, address);
			pstat.setInt(2, num);
			result = pstat.executeUpdate();

			pstat.close();
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return result;
	}

}
