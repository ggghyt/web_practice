package chap06;

public class Member_main {

	public static void main(String[] args) {
		Member member = new Member();
		member.name = "something";
		member.age = 256;
		Member member2 = new Member("not name", "not id");
		
		System.out.println("name : " + member.name);
		System.out.println("age : " + member.age);
		
		System.out.println("name : " + member2.name);
		System.out.println("id : " + member2.id);

	}

}
