import java.util.ArrayList;

public class WebView {
	public void printAddrList(ArrayList<Addr> list) {
		System.out.println("�� ���");
		System.out.println("====== �ּ� ��� ======");
		for(int i = 0; i < list.size(); i++) {
			Addr a = list.get(i);
			System.out.println("��ȣ : " + a.getId());
			System.out.println("�̸� : " + a.getName());
			System.out.println("�ּ� : " + a.getAddr());
			System.out.println("��ȭ : " + a.getPhone());
			System.out.println("===================");
		}
		
	}
}