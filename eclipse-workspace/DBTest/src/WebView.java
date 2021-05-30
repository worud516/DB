import java.util.ArrayList;

public class WebView {
	public void printAddrList(ArrayList<Addr> list) {
		System.out.println("웹 출력");
		System.out.println("====== 주소 목록 ======");
		for(int i = 0; i < list.size(); i++) {
			Addr a = list.get(i);
			System.out.println("번호 : " + a.getId());
			System.out.println("이름 : " + a.getName());
			System.out.println("주소 : " + a.getAddr());
			System.out.println("전화 : " + a.getPhone());
			System.out.println("===================");
		}
		
	}
}