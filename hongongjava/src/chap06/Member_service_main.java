package chap06;

public class Member_service_main {

	public static void main(String[] args) {
		Member_service memberservice = new Member_service();
		boolean result = memberservice.login("hong", "12345");
		
		if (result) {
			System.out.println("success login");
			memberservice.logout("hong");
		} else {
			System.out.println("something wrong");
		}
	}

}
