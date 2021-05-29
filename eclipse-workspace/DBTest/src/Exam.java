import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Exam {
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
		
		Scanner scan = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/t2?serverTimezone=UTC";
		String user = "root";
		String password = "";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, user, password);
		
		while(true) {
			System.out.println("명령어를 입력해주세요 : ");
			String cmd = scan.nextLine();
			
			if(cmd.equals("add")) {
				// 데이터 추가
				System.out.println("이름을 입력해주세요 : ");
				String name = scan.nextLine();
				System.out.println("주소를 입력해주세요 : ");
				String addr = scan.nextLine();
				System.out.println("전화번호를 입력해주세요 : ");
				String phone = scan.nextLine();
				
				Statement stmt = conn.createStatement();
				String sql = "INSERT INTO addr SET `name`='" + name + "', `addr`='" + addr + "', `phone`='" + phone + "'";
				System.out.println(sql);
				stmt.executeUpdate(sql);
				
			} else if(cmd.equals("list")) {
				
				Statement stmt = conn.createStatement();
				String sql = "SELECT * FROM addr";
				ResultSet rs = stmt.executeQuery(sql);
				
				System.out.println("=== 주소 목록 ===");
				while(rs.next()) {
					String id = rs.getString("id");
					String name = rs.getString("name");
					String addr = rs.getString("addr");
					String phone = rs.getString("phone");
					
					System.out.println("번호 : " + id);
					System.out.println("이름 : " + name);
					System.out.println("주소 : " + addr);
					System.out.println("전화 : " + phone);
					System.out.println("===================");
				}
				
			}
		}
	}

}