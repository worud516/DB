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

	public void printArticle(Article a, ArrayList<Reply> replyList) {
		System.out.println("====== �Խù� �󼼺��� ======");
		System.out.println("��ȣ : " + a.getId());
		System.out.println("���� : " + a.getTitle());
		System.out.println("���� : " + a.getBody());
		System.out.println("�ۼ��� : " + a.getRegDate());
		System.out.println("�ۼ��� : " + a.getName());
		System.out.println("��ȸ�� : " + a.getHit());
		System.out.println("===================");
		System.out.println("======== ��� ========");
		for (int i = 0; i < replyList.size(); i++) {
			Reply reply = replyList.get(i);
			System.out.println("���� : " + reply.getBody());
			System.out.println("�ۼ��� : " + reply.getName());
			System.out.println("�ۼ��� : " + reply.getRegDate());
			System.out.println("===================");
		}
	}
}