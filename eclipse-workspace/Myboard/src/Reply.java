public class Reply {

	private String body;
	private String name;
	private String regDate;

	public Reply(String body, String name, String regDate) {
		super();
		this.body = body;
		this.name = name;
		this.regDate = regDate;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

}