  
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
				
				Addr a = new Addr();
				a.setAddr(addr);
				a.setName(name);
				a.setPhone(phone);
				
				dao.insertAddr(a);
				
			} else if(cmd.equals("list")) {
				ArrayList<Addr> list = dao.getAddrList();
				view.printAddrList(list);

			} else if(cmd.equals("update")) {
				System.out.println("수정할 주소록 번호를 입력해주세요 :");
				int id = Integer.parseInt(scan.nextLine());
				System.out.println("이름을 입력해주세요 : ");
				String name = scan.nextLine();
				System.out.println("주소를 입력해주세요 : ");
				String addr = scan.nextLine();
				System.out.println("전화번호를 입력해주세요 : ");
				String phone = scan.nextLine();
				
				Addr a = new Addr();
				a.setId(id);
				a.setAddr(addr);
				a.setName(name);
				a.setPhone(phone);
				
				dao.updateAddr(a);
				
			} else if(cmd.equals("delete")) {
				
				System.out.println("삭제할 주소록 번호를 입력해주세요 : ");
				int id = Integer.parseInt(scan.nextLine());
				dao.deleteAddr(id);
				
			} else if(cmd.equals("search")) {
				
				System.out.println("검색할 대상의 이름을 입력해주세요 : ");
				String name = scan.nextLine();
				ArrayList<Addr> list = dao.getSearchedAddrByName(name);
				view.printAddrList(list);
				
			}
		}
	}
}