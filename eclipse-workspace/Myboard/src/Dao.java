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

	Connection conn = null;

	public void startTransaction() throws ClassNotFoundException, SQLException {
		conn = getConnection();
		conn.setAutoCommit(false);
	}

	public void endTransaction() throws SQLException {
		conn.commit();
		conn.close();
	}

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		if (conn == null) {
			conn = DriverManager.getConnection(url, user, password);
		}

		return conn;
	}

	public ArrayList<Article> getArticleList() throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();

		Statement stmt = conn.createStatement();

		String sql = "SELECT a.boardId, a.id, a.title, a.body, a.regDate, m.name, a.hit\r\n" + "FROM article a \r\n"
				+ "INNER JOIN `member` m\r\n" + "ON a.memberId = m.id";

		ResultSet rs = stmt.executeQuery(sql);

		ArrayList<Article> articleList = new ArrayList<>();

		while (rs.next()) {
			int id = rs.getInt("id");
			int boardId = rs.getInt("boardId");
			String title = rs.getString("title");
			String body = rs.getString("body");
			String regDate = rs.getString("regDate");
			String name = rs.getString("name");
			int hit = rs.getInt("hit");

			Article a = new Article(boardId, id, title, body, regDate, name, hit);

			articleList.add(a);
		}

		return articleList;
	}

	public Article getArticleById(int articleId) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();

		Statement stmt = conn.createStatement();
		String sql = "SELECT a.boardId, a.id, a.regDate, a.title, a.body, a.hit, m.name\r\n" + "FROM article a\r\n"
				+ "INNER JOIN `member` m\r\n" + "ON a.memberId = m.id\r\n" + "WHERE a.id = " + articleId;

		ResultSet rs = stmt.executeQuery(sql);
		Article article = null;

		if (rs.next()) {
			int id = rs.getInt("id");
			int boardId = rs.getInt("boardId");
			String title = rs.getString("title");
			String body = rs.getString("body");
			String regDate = rs.getString("regDate");
			String name = rs.getString("name");
			int hit = rs.getInt("hit");

			article = new Article(boardId, id, regDate, title, body, name, hit);
		}

		return article;
	}

	public ArrayList<Reply> getReplyList(int articleId) throws ClassNotFoundException, SQLException {

		Connection conn = getConnection();
		Statement stmt = conn.createStatement();

		String sql = "SELECT ar.body, m.name, ar.regDate\r\n" + "FROM articleReply ar\r\n" + "INNER JOIN `member` m\r\n"
				+ "ON ar.memberId = m.id\r\n" + "WHERE ar.articleId = " + articleId;

		ResultSet rs = stmt.executeQuery(sql);

		ArrayList<Reply> replyList = new ArrayList<>();

		while (rs.next()) {
			String body = rs.getString("body");
			String name = rs.getString("name");
			String regDate = rs.getString("regDate");

			Reply r = new Reply(body, name, regDate);

			replyList.add(r);
		}

		return replyList;

	}

	public void insertReply(int boardId, int articleId, String body) throws ClassNotFoundException, SQLException {

		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String sql = "INSERT INTO articleReply\r\n" + "SET regDate = NOW(),\r\n" + "BODY = '" + body + "',\r\n"
				+ "boardId = " + boardId + ",\r\n" + "articleId = " + articleId + ",\r\n" + "memberId = 2";

		stmt.executeUpdate(sql);

	}

	public void deleteArticle(int id) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String sql = "DELETE FROM article WHERE id = " + id;
		stmt.executeUpdate(sql);
	}

	public void deleteReply(int id) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String sql = "DELETE FROM articleReply WHERE articleId = " + id;
		System.out.println(sql);
		stmt.executeUpdate(sql);
	}
}