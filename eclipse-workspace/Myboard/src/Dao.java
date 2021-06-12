import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Dao {
	String url = "jdbc:mysql://localhost:3306/myboard?serverTimezone=UTC";
	String user = "root";
	String password = "";

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}

	public ArrayList<Article> getArticleList() throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();

		String sql = "SELECT a.id, a.title, a.body, a.regDate, m.name, a.hit\r\n" + "FROM article a \r\n"
				+ "INNER JOIN `member` m\r\n" + "ON a.memberId = m.id";

		ResultSet rs = stmt.executeQuery(sql);

		ArrayList<Article> articleList = new ArrayList<>();

		while (rs.next()) {
			int id = rs.getInt("id");
			String title = rs.getString("title");
			String body = rs.getString("body");
			String regDate = rs.getString("regDate");
			String name = rs.getString("name");
			int hit = rs.getInt("hit");

			Article a = new Article(id, title, body, regDate, name, hit);

			articleList.add(a);
		}

		return articleList;
	}

	public void insertAddr(Article addr) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		// String sql = "INSERT INTO addr SET `name`='" + addr.getName() + "', `addr`='"
		// + addr.getAddr() + "', `phone`='" + addr.getPhone() + "'";
		// stmt.executeUpdate(sql);
	}

	public void updateAddr(Article addr) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		// String sql = "UPDATE addr SET `name`='"+ addr.getName() + "', `addr`='" +
		// addr.getAddr() + "', `phone`='" + addr.getPhone() + "' WHERE id = " +
		// addr.getId();
		// stmt.executeUpdate(sql);
	}

	public void deleteAddr(int id) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String sql = "DELETE FROM addr WHERE id = " + id;
		stmt.executeUpdate(sql);
	}
}