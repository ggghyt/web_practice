package chap07;

public class Http_servlet_main {

	public static void main(String[] args) {
		method(new Login_servlet());
		method(new File_download_servlet());
	}

	public static void method (Http_servlet servlet) {
		servlet.service();
	}
}
