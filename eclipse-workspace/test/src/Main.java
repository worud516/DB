import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		ArrayList<String> alist = new ArrayList<>();
		
		
		// 드라이버 클래스를 찾겠다.
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// 드라이버를 찾으면 DriverManager라는 클래스 활성
		// Connection을 이용해 DBMS와 연결
		// DBMS 서버 주소 == MySQL Host Address
		String url = "jdbc:mysql://localhost:3306/t2?serverTimezone=UTC";
		// 사용자 이름
		String user = "root";
		// 비밀번호
		String password = "";
		
		
		// Connection -> DBMS 접속정보와 통신 관련 기능을 제공.
		Connection conn = DriverManager.getConnection(url, user, password);
		
		System.out.println(conn); // null이면 접속 실패
		
		// sql 처리
		// Statement 객체 -> sql처리, 데이터를 주고받는 기능 제공
		Statement stmt = conn.createStatement();
		
		String sql = "SELECT * FROM article";
		ResultSet rs = stmt.executeQuery(sql); // executeQuery(sql) -> sql을 dbms에 전달해서 처리 조회결과는 ResultSet 객체로 넘어온다.
				
		//ResultSet에서 데이터 꺼내기
//		rs.next();
		
		//rs.getString("컬럼명");
//		String title = rs.getString("title");
//		String body = rs.getString("body");
//		System.out.println(title);
//		System.out.println(body);
//		
//		rs.next();
//		String title2 = rs.getString("title");
//		String body2 = rs.getString("body");
//		System.out.println(title2);
//		System.out.println(body2);
		
		
		// 다건을 반복 조회하는 법 rs.next()는 boolean값 반환
		while(rs.next()) {
			String title = rs.getString("title");
			String body = rs.getString("body");
			System.out.println("제목 : " + title + ", 내용 : " + body);
		}
		
		// delete, update, insert를 처리할 경우
		String sql2 = "UPDATE article SET title = 'aaa' WHERE id = 2";
		stmt.executeUpdate(sql2);
				
		
	}

}
