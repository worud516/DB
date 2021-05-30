import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Exam {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {

		Scanner scan = new Scanner(System.in);
		Dao dao = new Dao();
		View view = new View();
		WebView wv = new WebView();

		while (true) {
			System.out.println("명령어를 입력해주세요 : ");
			String cmd = scan.nextLine();

			if (cmd.equals("add")) {
				// 데이터 추가
				System.out.println("이름을 입력해주세요 : ");
				String name = scan.nextLine();
				System.out.println("주소를 입력해주세요 : ");
				String addr = scan.nextLine();
				System.out.println("전화번호를 입력해주세요 : ");
				String phone = scan.nextLine();

//				Statement stmt = conn.createStatement();
//				String sql = "INSERT INTO addr SET `name`='" + name + "', `addr`='" + addr + "', `phone`='" + phone + "'";
//				System.out.println(sql);
//				stmt.executeUpdate(sql);

			} else if (cmd.equals("list")) {
				ArrayList<Addr> list = dao.getAddrList();
				view.printAddrList(list);
				// wv.printAddrList(list);
			}
		}
	}
}