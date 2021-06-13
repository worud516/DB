import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static Scanner scan = new Scanner(System.in);
	static Dao dao = new Dao();
	static View view = new View();

	public static void main(String[] args) throws Exception {

		while (true) {
			System.out.println("��ɾ �Է����ּ��� : ");
			String cmd = scan.nextLine();

			if (cmd.equals("add")) {

			} else if (cmd.equals("list")) {
				ArrayList<Article> list = dao.getArticleList();
				view.printArticleList(list);

			} else if (cmd.equals("update")) {

			} else if (cmd.equals("delete")) {

				System.out.println("���ܸ� �߻���ŵ�ϱ�? (y/n)");
				String flag = scan.nextLine();

				System.out.println("������ �Խù� ��ȣ�� �Է����ּ��� : ");
				int id = Integer.parseInt(scan.nextLine());
				// Ʈ����� ����
				dao.startTransaction();
				dao.deleteArticle(id);
				// ============ ���⼭ ������ ����� =============
				// exception -> ����
				if (flag.equals("y")) {
					throw new Exception();
				}

				dao.deleteReply(id);
				dao.endTransaction();
				// Ʈ����� ����

			} else if (cmd.equals("read")) {
				System.out.println("�󼼺��� �� �Խù� ��ȣ�� �Է����ּ��� : ");
				int articleId = Integer.parseInt(scan.nextLine());

				Article article = dao.getArticleById(articleId);
				if (article == null) {
					System.out.println("�Խù��� �������� �ʽ��ϴ�.");
					continue;
				}
				ArrayList<Reply> replyList = dao.getReplyList(articleId);

				view.printArticle(article, replyList);

				readProcess(article);

			}
		}
	}

	public static void readProcess(Article article) throws ClassNotFoundException, SQLException {

		while (true) {
			System.out.println("�󼼺��� ����� �������ּ���(1. ��� ���, 2. �������) : ");
			int readCmd = Integer.parseInt(scan.nextLine());
			if (readCmd == 1) {
				System.out.println("��� ������ �Է����ּ��� :");
				String body = scan.nextLine();

				dao.insertReply(article.getBoardId(), article.getId(), body);
				ArrayList<Reply> replyList = dao.getReplyList(article.getId());
				view.printArticle(article, replyList);

			} else if (readCmd == 2) {
				break;
			}
		}
	}
}