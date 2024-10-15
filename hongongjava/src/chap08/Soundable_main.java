package chap08;

public class Soundable_main {
	private static void print_sound(Soundable soundable) {
		System.out.println(soundable.sound());
	}


	public static void main(String[] args) {
		print_sound(new Cat());
		print_sound(new Dog());
	}

}
