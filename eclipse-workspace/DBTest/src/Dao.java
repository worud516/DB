import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//DB
public class Dao {
	String url = "jdbc:mysql://localhost:3306/t2?serverTimezone=UTC";
	String user = "root";
	String password = "";
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, user, password);		
		return conn;
	}
	
	public ArrayList<Addr> getAddrList() throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String sql = "SELECT * FROM addr";
		ResultSet rs = stmt.executeQuery(sql);
		
		ArrayList<Addr> addrList = new ArrayList<>();
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String addr = rs.getString("addr");
			String phone = rs.getString("phone");
			
			Addr a = new Addr();
			a.setId(id);
			a.setName(name);
			a.setAddr(addr);
			a.setPhone(phone);
			
			addrList.add(a);
		}
		
		return addrList;
	}
	
	public void insertAddr(Addr addr) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String sql = "INSERT INTO addr SET `name`='" + addr.getName() + "', `addr`='" + addr.getAddr() + "', `phone`='" + addr.getPhone() + "'";
		stmt.executeUpdate(sql);
	}

	public void updateAddr(Addr addr) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String sql = "UPDATE addr SET `name`='"+ addr.getName() + "', `addr`='" + addr.getAddr() + "', `phone`='" + addr.getPhone() + "' WHERE id = " + addr.getId();
		stmt.executeUpdate(sql);
	}
	
	public void deleteAddr(int id) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String sql = "DELETE FROM addr WHERE id = " + id;
		stmt.executeUpdate(sql);
	}

	public ArrayList<Addr> getSearchedAddrByName(String keyword) throws ClassNotFoundException, SQLException {

		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String sql = "SELECT * FROM addr WHERE name LIKE '%" + keyword + "%'";
		
		System.out.println(sql);
		ResultSet rs = stmt.executeQuery(sql);
		
		ArrayList<Addr> addrList = new ArrayList<>();
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String addr = rs.getString("addr");
			String phone = rs.getString("phone");
			
			Addr a = new Addr();
			a.setId(id);
			a.setName(name);
			a.setAddr(addr);
			a.setPhone(phone);
			
			addrList.add(a);
		}
		
		return addrList;
	}
}