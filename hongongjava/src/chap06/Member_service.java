package chap06;

public class Member_service {
	boolean login(String id, String pw) {
		if (id.equals("hong") && pw.equals("12345")) {
			return true;
		} else {
			return false;
		}
	}
	
	void logout(String id) {
		System.out.println("success logout " + id);
	}
}
