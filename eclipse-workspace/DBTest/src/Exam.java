  
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
			System.out.println("��ɾ �Է����ּ��� : ");
			String cmd = scan.nextLine();
			
			if(cmd.equals("add")) {
				// ������ �߰�
				System.out.println("�̸��� �Է����ּ��� : ");
				String name = scan.nextLine();
				System.out.println("�ּҸ� �Է����ּ��� : ");
				String addr = scan.nextLine();
				System.out.println("��ȭ��ȣ�� �Է����ּ��� : ");
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
				System.out.println("������ �ּҷ� ��ȣ�� �Է����ּ��� :");
				int id = Integer.parseInt(scan.nextLine());
				System.out.println("�̸��� �Է����ּ��� : ");
				String name = scan.nextLine();
				System.out.println("�ּҸ� �Է����ּ��� : ");
				String addr = scan.nextLine();
				System.out.println("��ȭ��ȣ�� �Է����ּ��� : ");
				String phone = scan.nextLine();
				
				Addr a = new Addr();
				a.setId(id);
				a.setAddr(addr);
				a.setName(name);
				a.setPhone(phone);
				
				dao.updateAddr(a);
				
			} else if(cmd.equals("delete")) {
				
				System.out.println("������ �ּҷ� ��ȣ�� �Է����ּ��� : ");
				int id = Integer.parseInt(scan.nextLine());
				dao.deleteAddr(id);
				
			} else if(cmd.equals("search")) {
				
				System.out.println("�˻��� ����� �̸��� �Է����ּ��� : ");
				String name = scan.nextLine();
				ArrayList<Addr> list = dao.getSearchedAddrByName(name);
				view.printAddrList(list);
				
			}
		}
	}
}