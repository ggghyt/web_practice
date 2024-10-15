package self_project;

public class Inquiry {
	private int inq_num;
	private String inq_title;
	private String inq_content;
	private String inq_answer;
	private String user_id;
	
	public String get_inq_answer() {
		return inq_answer;
	}
	public void set_inq_answer(String inp_answer) {
		this.inq_answer = inp_answer;
	}
	public int get_inq_num() {
		return inq_num;
	}
	public void set_inq_num(int inq_num) {
		this.inq_num = inq_num;
	}
	public String get_inq_title() {
		return inq_title;
	}
	public void set_inq_title(String inq_title) {
		this.inq_title = inq_title;
	}
	public String get_inq_content() {
		return inq_content;
	}
	public void set_inq_content(String inq_content) {
		this.inq_content = inq_content;
	}
	public String get_user_id() {
		return user_id;
	}
	public void set_user_id(String user_id) {
		this.user_id = user_id;
	}
}
