package chap08;

public class Cat implements Soundable {
	String sound = "cat";
	@Override
	public String sound() {
		return sound;
	}
}
