import java.util.ArrayList;

public class View {
	public void printArticleList(ArrayList<Article> list) {
		System.out.println("====== �Խù� ��� ======");
		for (int i = 0; i < list.size(); i++) {
			Article a = list.get(i);
			System.out.println("��ȣ : " + a.getId());
			System.out.println("���� : " + a.getTitle());
			System.out.println("�ۼ��� : " + a.getRegDate());
			System.out.println("�ۼ��� : " + a.getName());
			System.out.println("��ȸ�� : " + a.getHit());
			System.out.println("===================");
		}

	}
}
