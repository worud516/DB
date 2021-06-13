import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static Scanner scan = new Scanner(System.in);
	static Dao dao = new Dao();
	static View view = new View();

	public static void main(String[] args) throws Exception {

		while (true) {
			System.out.println("명령어를 입력해주세요 : ");
			String cmd = scan.nextLine();

			if (cmd.equals("add")) {

			} else if (cmd.equals("list")) {
				ArrayList<Article> list = dao.getArticleList();
				view.printArticleList(list);

			} else if (cmd.equals("update")) {

			} else if (cmd.equals("delete")) {

				System.out.println("예외를 발생시킵니까? (y/n)");
				String flag = scan.nextLine();

				System.out.println("삭제할 게시물 번호를 입력해주세요 : ");
				int id = Integer.parseInt(scan.nextLine());
				// 트랜잭션 시작
				dao.startTransaction();
				dao.deleteArticle(id);
				// ============ 여기서 문제가 생기면 =============
				// exception -> 예외
				if (flag.equals("y")) {
					throw new Exception();
				}

				dao.deleteReply(id);
				dao.endTransaction();
				// 트랜잭션 종료

			} else if (cmd.equals("read")) {
				System.out.println("상세보기 할 게시물 번호를 입력해주세요 : ");
				int articleId = Integer.parseInt(scan.nextLine());

				Article article = dao.getArticleById(articleId);
				if (article == null) {
					System.out.println("게시물이 존재하지 않습니다.");
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
			System.out.println("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 목록으로) : ");
			int readCmd = Integer.parseInt(scan.nextLine());
			if (readCmd == 1) {
				System.out.println("댓글 내용을 입력해주세요 :");
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