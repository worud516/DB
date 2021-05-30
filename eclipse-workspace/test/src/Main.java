import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		ArrayList<String> alist = new ArrayList<>();
		
		
		// ����̹� Ŭ������ ã�ڴ�.
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// ����̹��� ã���� DriverManager��� Ŭ���� Ȱ��
		// Connection�� �̿��� DBMS�� ����
		// DBMS ���� �ּ� == MySQL Host Address
		String url = "jdbc:mysql://localhost:3306/t2?serverTimezone=UTC";
		// ����� �̸�
		String user = "root";
		// ��й�ȣ
		String password = "";
		
		
		// Connection -> DBMS ���������� ��� ���� ����� ����.
		Connection conn = DriverManager.getConnection(url, user, password);
		
		System.out.println(conn); // null�̸� ���� ����
		
		// sql ó��
		// Statement ��ü -> sqló��, �����͸� �ְ�޴� ��� ����
		Statement stmt = conn.createStatement();
		
		String sql = "SELECT * FROM article";
		ResultSet rs = stmt.executeQuery(sql); // executeQuery(sql) -> sql�� dbms�� �����ؼ� ó�� ��ȸ����� ResultSet ��ü�� �Ѿ�´�.
				
		//ResultSet���� ������ ������
//		rs.next();
		
		//rs.getString("�÷���");
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
		
		
		// �ٰ��� �ݺ� ��ȸ�ϴ� �� rs.next()�� boolean�� ��ȯ
		while(rs.next()) {
			String title = rs.getString("title");
			String body = rs.getString("body");
			System.out.println("���� : " + title + ", ���� : " + body);
		}
		
		// delete, update, insert�� ó���� ���
		String sql2 = "UPDATE article SET title = 'aaa' WHERE id = 2";
		stmt.executeUpdate(sql2);
				
		
	}

}
