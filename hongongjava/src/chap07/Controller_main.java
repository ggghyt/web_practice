package chap07;

public class Controller_main {

	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.set_service(new Member_service());
		controller.service.login();
		
		controller.set_service(new A_service());
		controller.service.login();

	}

}
