package chap08;

public class Dog implements Soundable {
	String dog = "dog";
	@Override
	public String sound() {
		return dog;
	}
}
