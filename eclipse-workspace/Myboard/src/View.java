import java.util.ArrayList;

public class View {
	public void printArticleList(ArrayList<Article> list) {
		System.out.println("====== 게시물 목록 ======");
		for (int i = 0; i < list.size(); i++) {
			Article a = list.get(i);
			System.out.println("번호 : " + a.getId());
			System.out.println("제목 : " + a.getTitle());
			System.out.println("작성일 : " + a.getRegDate());
			System.out.println("작성자 : " + a.getName());
			System.out.println("조회수 : " + a.getHit());
			System.out.println("===================");
		}

	}
}
